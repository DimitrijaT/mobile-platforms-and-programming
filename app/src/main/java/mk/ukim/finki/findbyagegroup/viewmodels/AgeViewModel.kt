package mk.ukim.finki.findbyagegroup.viewmodels

import androidx.lifecycle.ViewModel

class AgeViewModel : ViewModel() {

    private var _age: Int = -1

    fun getAgeValue(): Int {
        return _age
    }

    fun setAgeValue(age: Int) {
        this._age = age
    }

    fun calcAgeGroup(): String {
        return when (this._age) {
            in 0..14 -> "Child";
            in 15..24 -> "Youth";
            in 25..64 -> "Adult";
            in 65..200 -> "Senior";
            else -> "Not Known"
        }
    }


}