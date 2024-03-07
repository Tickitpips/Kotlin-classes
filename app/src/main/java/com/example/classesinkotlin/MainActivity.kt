package com.example.classesinkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.classesinkotlin.ui.theme.ClassesInKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClassesInKotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClassesInKotlinTheme {
        Greeting("Android")
    }
}

//Creating a class
class SmartDevice{      //Created a class whose name is SmartDevice
    fun turnOn(){
        //A turn on method defined in the class SmartDevice
        println("Smart device is turned on.")
    }
    fun turnOff(){
        //A turn off method defined in the class SmartDevice
        println("Smart device is turned off.")
    }
}

//Using a class in a function
fun main(){             //Created a function whose name is main
    //calling SmartDevice class and assigning the object to smartTvDevice variable
    val smartTvDevice = SmartDevice()
    smartTvDevice.turnOn()       //calling the turnOn() method
    smartTvDevice.turnOff()
    //Therefore, by calling the SmartDevice class, we have inherited
    //turnOn() and turnOff() methods of the class
}

//Adding properties to the class
class SmartDevice2{

    //introducing properties into the class
    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "Online"

    fun turnOn(){
        println("Smart device is turned on.")
    }
    fun turnOff(){
        println("Smart device is turned off.")
    }
}

//Using properties declared in a class
fun main2(){

    val smartTvDevice = SmartDevice2()
    println("Device name is: ${smartTvDevice.name}") //using a property defined in the SmartDevice class
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

//Using getter and setter function
class SmartDevice3{


    val name = "Android TV"
    val category = "Entertainment"
    var deviceStatus = "Online"
    var speakerVolume = 2    //holds the current volume level set on the TV speaker
        get() = field        //gets a value
        set(value) {
            field = value
        }

    fun turnOn(){
        println("Smart device is turned on.")
    }
    fun turnOff(){
        println("Smart device is turned off.")
    }
}

fun main3(){

    val smartTvDevice = SmartDevice3()
    println("Device name is: ${smartTvDevice.name}") //using a property defined in the SmartDevice class
    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

//Defining parametized constructors
open class SmartDevice4(val name: String, val category: String){  //By defining parametized constructors,
    // You need to ensure that all the instances of the SmartDevice class
    // initialize the name and category properties.
    var deviceStatus = "online"

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

//Calling a class with parametized constructors
fun main4(){
    val smartTvDevice = SmartDevice4("Android TV", "Entertainment")
}

//Defining a class with secondary constructors
class SmartDevice5(val name: String, val category: String) {
    var deviceStatus = "online"

//secondary constructor in the SmartDevice class converts the statusCode parameter to string representation
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
}

//Extending a class
open class SmartDevice6(val name:String, val category:String){}

//A SmartTvDevice class that extends a SmartDevice superclass
class SmartTvDevice(deviceName: String, deviceCategory: String) :
        SmartDevice4(name = deviceName, category = deviceCategory) {

        var speakerVolume = 2
            set(value) {
                if (value in 0..100) {
                    field = value
                }
            }
        var channelNumber = 1
            set(value) {
                if (value in 0..200) {
                    field = value
                }
            }
        fun increaseSpeakerVolume() {
            speakerVolume++
            println("Speaker volume increased to $speakerVolume.")
        }

        fun nextChannel() {
            channelNumber++
            println("Channel number increased to $channelNumber.")
        }
    class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice4(name = deviceName, category = deviceCategory) {

        var brightnessLevel = 0
            set(value) {
                if (value in 0..100) {
                    field = value
                }
            }
        fun increaseBrightness() {
            brightnessLevel++
            println("Brightness increased to $brightnessLevel.")
        }
    }
}

// The SmartHome class HAS-A smart TV device.
class SmartHome(val smartTvDevice: SmartTvDevice) {

    fun turnOnTv() {
        smartTvDevice.turnOn()
    }
    fun turnOffTv() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }
}
