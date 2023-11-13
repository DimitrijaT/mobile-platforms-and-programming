package mk.ukim.finki.findbyagegroup.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AgeViewModel : ViewModel() {

    private val _age: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun getAgeValue(): Int {
        return _age.value ?: -1
    }

    fun setAgeValue(age: Int) {
        this._age.value = age
    }

    fun calcAgeGroup(): String {
        return when (this._age.value) {
            in 0..14 -> "Child";
            in 15..24 -> "Youth";
            in 25..64 -> "Adult";
            in 65..200 -> "Senior";
            else -> "Not Known"
        }
    }

    fun getAge(): MutableLiveData<Int> {
        return _age
    }

}


