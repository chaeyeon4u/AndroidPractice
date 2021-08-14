package com.example.kotlinpractice

//open => 클래스와 함수에 상속을 위해 사용해야한다. Kotlin은 같은 클래스에 있다고 하더라도 바로 상속 못한다.
//파라미터가 하나의 문자열인경우 name에 넣고, 파라미터가 없을 경우 "Anonymous"를 사용하라.
open class Human(val name:String = "Anonymous") {
    constructor(name : String, age: Int) : this(name){//생성자
        println("my name is ${name} and ${age} years old")
    }

    init {//제일 먼저 실행됨
        println("Hello World")
    }
    fun eatingCake(){
        println("this is so YUMMYYY")
    }
    open fun singASong(){
        println("Parents Sing A Song")
    }
}

//Human() 상속 -> 다형성
class Korean : Human(){
    //override
    override fun singASong(){
        //부모 클래스의 함수 사용
        super.singASong()
        println("Child Sing A Song")
        //부모클래스인 Human()에 name에 대한 default를 설정해줘서 가능
        println("my name is : ${name}")
    }
}


fun main(){
//    val human = Human("chaeyeon")
//    human.eatingCake()
//
//    println("name : ${human.name}")
//    val stranger = Human()
//    stranger.eatingCake()
    val human2 = Human("chaeyeon", 23)

    val korean = Korean()
    korean.singASong()
}