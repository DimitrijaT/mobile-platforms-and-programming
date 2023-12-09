package mk.ukim.finki.findbyagegroup.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NicknameViewModel : ViewModel() {

    private val mutableNickname: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val nickname: LiveData<String> get() = mutableNickname

    fun selectNickname(nickname: String) {
        mutableNickname.value = nickname
    }
}

