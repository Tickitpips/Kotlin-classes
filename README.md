# Kotlin-classes
Understanding classes in Android programming

This is an implementation of the classes in Kotlin tutorial from https://developer.android.com/codelabs/basic-android-kotlin-compose-classes-and-objects?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-classes-and-objects#9
I have modified the original code with comments to give a better understanding of inheritance, encapsulation, and abstraction using Kotlin for Android programming. 

Version 1

In the classes tutorial, we are creating a smart home with a smart devices. The devices are a smart TV and a smart light. A smart TV should fundamentally have a function to turn it on and off, and so should a smart light. 
1.	Create a class and name it SmartDevice to define the turn on and turn off functions.
2.	Create a main function to call the turn on and turn off functions from the SmartDevice class
   
Version 2 

But we need to at least give the device a name, categorize it and know whether it is online or offline. We therefore upgrade the SmartDevice class by declaring name, category and deviceStatus properties.

Version 3

Here, we define a getter and setter function that is an inherent property of the smart device. The getter and setter fucntions are used to get certain properties from the device such as the brightness level of a smart light or the volume level of the TV. It gets the property and sets it. 

Version 4

In this version, we use the keyword ‘open’ before declaring the class so that we can use the class attributes in a subclass. When creating a subclass that needs to inherit properties from a superclass, you need to open the superclass lest the compiler throw an error. Around line 164, the SmartTvDevice class is a subclass of class SmartDevice4 and around line 188, the SmartLightDevice is a subclass of SmartDevice4. 
In the SmartTvDevice subclass, we declare the speakerVolume variable and the channelNumber variables, get their values and set them. We also define functions to increase volume and change channels. 
