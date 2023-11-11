package mk.ukim.finki.findbyagegroup.extensions;

import android.text.Editable

fun Editable?.toInt(): Int {
    return this.toString().toIntOrNull() ?: -1
}


