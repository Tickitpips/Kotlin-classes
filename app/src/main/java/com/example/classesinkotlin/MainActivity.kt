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
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

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
        SmartDevice4(name = deviceName, category = deviceCategory) { //SmartDevice4 is a parent class to SmartTvDevice

        var speakerVolume = 2           //sets initial speaker volume
            set(value) {
                if (value in 0..100) {   //Simply defines the expected range of the values
                    field = value
                }
            }
        var channelNumber = 1            //sets initial channel number
            set(value) {
                if (value in 0..200) {
                    field = value
                }
            }
        fun increaseSpeakerVolume() {       //Describes a function to increase speaker volume of the TV
            speakerVolume++
            println("Speaker volume increased to $speakerVolume.")
        }

        fun nextChannel() {              //Describes a function to change to the next channel of the TV
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

//Final solution with modifiers and related classes


open class SmartDevice9(val name: String, val category: String) { //Creating a superclass for smart devices

    var deviceStatus = "online"
        protected set                          //Accessible in same class and subclass

    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice9(deviceName: String, deviceCategory: String) : //Declaring SmartTvDevice9 subclass
    SmartDevice9(name = deviceName, category = deviceCategory) {   //SmartDevice9is the superclass

    override val deviceType = "Smart TV"                           //overrides deviceType property declared in the SmartDevice9 class

    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    override fun turnOn() {      //overriding method from the superclass under this subclass
        super.turnOn()           //calling the overridden method using the super keyword
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) : //Declaring SmartLightDevice subclass
    SmartDevice9(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome9(
    val smartTvDevice: SmartTvDevice,           //class SmartHome9 has a smartTvDevice.   Code means we are creating a smartDevice property of SmartTvDevice type
    val smartLightDevice: SmartLightDevice      //class SmartHome9 has a smartLightDevice
) {

    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

class RangeRegulator(
//class RangeRegulator helps us create an interface to help with the abstraction of the getter and setter function
// It implements the ReadWriteProperty<Any?, Int> interface

    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main9() {
    var smartDevice: SmartDevice9 = SmartTvDevice9("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}

/*After the main function is run, the output should be:

>>>Android TV is turned on. Speaker volume is set to 2 and channel number is set to 1.
Google Light turned on. The brightness level is 2.

 */