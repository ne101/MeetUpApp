package com.example.wb_homework.viewmodels

import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Profile
import com.example.domain.entities.Tags
import com.example.domain.usecases.community_usecases.DeleteAllCommunitiesUseCase
import com.example.domain.usecases.community_usecases.GetMyCommunityListUseCase
import com.example.domain.usecases.event_usecases.DeleteAllEventsUseCase
import com.example.domain.usecases.event_usecases.GetMyEventListUseCase
import com.example.domain.usecases.profile_usecases.DeleteProfileUseCase
import com.example.domain.usecases.profile_usecases.GetProfileUseCase
import com.example.domain.usecases.profile_usecases.IsProfileExistsUseCase
import com.example.domain.usecases.profile_usecases.SaveProfileUseCase
import com.example.domain.usecases.profile_usecases.UpdateProfileUseCase
import com.example.domain.usecases.tags_usecases.GetMyTagsUseCase
import com.example.domain.usecases.tags_usecases.GetTagsUseCase
import com.example.domain.usecases.tags_usecases.SetMyTagsUseCase
import com.example.wb_homework.ui.screen_state.ProfileScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val saveProfileUseCase: SaveProfileUseCase,
    private val isProfileExistsUseCase: IsProfileExistsUseCase,
    private val getMyEventListUseCase: GetMyEventListUseCase,
    private val getMyCommunityListUseCase: GetMyCommunityListUseCase,
    private val getMyTagsUseCase: GetMyTagsUseCase,
    private val setMyTagsUseCase: SetMyTagsUseCase,
    private val getTagsUseCase: GetTagsUseCase,
    private val deleteAllEventsUseCase: DeleteAllEventsUseCase,
    private val deleteAllCommunitiesUseCase: DeleteAllCommunitiesUseCase,
    private val deleteProfileUseCase: DeleteProfileUseCase
) : BaseViewModel() {

    private val _screenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Initial)
    private val screenState = _screenState.asStateFlow()

    private val profileFlow = getProfileUseCase.execute().stateInViewModelScope(null)
    private val communitiesFlow = getMyCommunityListUseCase.execute().stateInViewModelScope(null)
    private val eventsFlow = getMyEventListUseCase.execute().stateInViewModelScope(null)
    private val myTagsFlow = getMyTagsUseCase.execute().stateInViewModelScope(null)
    private val tagsFlow = getTagsUseCase.execute().stateInViewModelScope(null)
    private val currentTags = MutableStateFlow<List<String>>(emptyList())

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _screenState.update { ProfileScreenState.Error(throwable.message ?: "Unknown error") }
    }

    init {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            if (isProfileExistsUseCase.execute().first()) {
                fetchInitialData()
            } else {
                saveProfileUseCase.execute(Profile())
                fetchInitialData()
            }
        }
    }

    fun getScreenState() = screenState

    fun fetchInitialData() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            combine(
                profileFlow.filterNotNull(),
                communitiesFlow.filterNotNull(),
                eventsFlow.filterNotNull(),
                myTagsFlow.filterNotNull(),
            ) { profile, communities, events, tags ->
                val updateProfile = profile.copy(
                    communities = communities,
                    events = events,
                    tags = tags
                )
                ProfileScreenState.MainContent(updateProfile)
            }.collect { newState ->
                _screenState.update { newState }
                updateProfileUseCase.execute(newState.profile)
            }
        }
    }


    fun startEditState(profile: Profile) {
        _screenState.update {
            ProfileScreenState.EditContent(profile)
        }
    }

    fun startEditTagsState(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            currentTags.update {
                profile.tags.tags
            }
            combine(currentTags, tagsFlow.filterNotNull()) { currentTags, tags ->
                ProfileScreenState.EditTags(
                    profile = profile,
                    tags = tags.tags,
                    currentTags = currentTags,
                )
            }.collect { tags ->
                _screenState.update { tags }
            }
        }
    }

    fun updateTagsInEditState(profile: Profile, tags: List<String>) {
        _screenState.update {
            ProfileScreenState.EditContent(profile.copy(tags = Tags(tags)))
        }
    }

    fun canselEditTagsState(profile: Profile) {
        _screenState.update {
            ProfileScreenState.EditContent(profile)
        }
    }


    fun setTagsInDB(tags: List<String>) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            setMyTagsUseCase.execute(tags)
        }
    }

    fun updateTags(tag: String) {
        currentTags.update {
            if (it.contains(tag)) {
                it - tag
            } else {
                it + tag
            }
        }
    }

    fun updateProfileField(field: String, value: Any) {
        _screenState.update {
            val profile = (it as ProfileScreenState.EditContent).profile
            val updatedProfile = when (field) {
                "name" -> profile.copy(name = value as String)
                "phone" -> profile.copy(phone = value as String)
                "city" -> profile.copy(city = value as String)
                "description" -> profile.copy(description = value as String)
                "avatar" -> profile.copy(avatar = value as String)
                "tags" -> profile.copy(tags = value as Tags)
                "habrName" -> profile.copy(habrName = value as String)
                "telegramName" -> profile.copy(telegramName = value as String)
                "showEvents" -> profile.copy(showEvents = value as Boolean)
                "showCommunities" -> profile.copy(showCommunities = value as Boolean)
                else -> profile
            }
            ProfileScreenState.EditContent(updatedProfile)
        }
    }

    fun canselEditState() {
        _screenState.update {
            ProfileScreenState.MainContent(profileFlow.value ?: Profile())
        }
    }

    fun updateProfile(profile: Profile) {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            updateProfileUseCase.execute(profile)
            canselEditState()
        }
    }

    fun logOut() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            saveProfileUseCase.execute(Profile())
            deleteAllEventsUseCase.execute()
            deleteAllCommunitiesUseCase.execute()
            setMyTagsUseCase.execute(emptyList())
        }
    }
}