package com.example.calc_1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewModel : ViewModel() {


    private val _equationText = MutableLiveData("")
    val equationText: LiveData<String> = _equationText


    private val _resultText = MutableLiveData("0")
    val resultText: LiveData<String> = _resultText


    fun onButtonClick(btn: String) {
        Log.i("Clicked Button", btn)


        _equationText.value?.let { equation ->
            when (btn) {
                "AC" -> {
                    _equationText.value = ""
                    _resultText.value = "0"
                    return
                }

                "%" -> {
                    _equationText.value = equation + "/100"
                    return
                }

                "C" -> {
                    if (equation.isNotEmpty()) {
                        _equationText.value = equation.substring(0, equation.length - 1)
                    }
                    return
                }
                "=" -> {
                    try {
                        _resultText.value = calcualteResult(equation)
                    } catch (e: Exception) {
                        _resultText.value = "Error"
                    }
                    return
                }
                else -> {
                    _equationText.value = equation + btn
                }
            }
        }
    }


    fun calcualteResult(equation: String): String {
        val context: Context = Context.enter()
        context.optimizationLevel = -1
        val scriptable: Scriptable = context.initStandardObjects()
        var finalResult = context.evaluateString(scriptable, equation, "JavaScript", 1, null).toString()

        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.replace(".0", "")
        }

        Context.exit()
        return finalResult
    }
}
