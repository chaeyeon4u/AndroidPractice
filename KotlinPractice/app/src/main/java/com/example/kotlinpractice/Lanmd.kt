package com.example.kotlinpractice

//1. Lamda
//람다식은 우리가 미치 value 처럼 다룰 수 있는 익명함수이다.
//1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(람다식으로 함수 사용 가능)
//2) 리턴값으로 사용할 수 있다.

//람다의 기본 정의
//val lamdaName : Type = { argumentList -> codeBody}
//(Int) -> (Int) 는 Input Type Int, output Type Int
val square : (Int) -> (Int) = {number /*: Int*/ -> number*number}

val nameAge : (String, Int) -> (String) = {name : String, age : Int ->
    "my name is ${name}, I'm ${age}"
}

//2. 람다식 확장함수
//확장함수 : 점(.)을 통해 접근하는 함수를 확장함수라고 하는듯?
//확장한다는 것은 다형성과 관련있는 듯 하다.
// Input Type String.() : 불러오는 인자는 String인데 매개변수는 없어요..
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best"
}

fun ExtendString(name : String, age : Int) : String{
    //람다식 확장함수
    //String.(Int) 에서 String은 불러오는 값의 타입, Int는 매개변수 값
    //String.(Int)에서 this는 불러오는 값의 타입을 의미하고, it은 매개변수가 하나일 때 축약해서 사용하는 방법이다.
    val introduceMySelf : String.(Int) -> String = {
        "my name is ${name} and I'm ${} years old"
    }
    return name.introduceMySelf(age)
}

//람다식의(Lamda) return
val calculateGrade : (Int) -> String = {
    //when()은 else 무조건 정의해줘야한다.
    when(it){
        in 0..40 -> "Fail"
        in 40..70 -> "Okay"
        in 70..100 -> "Great"
        else -> "Unsolved Grade"
    }
}

//람다를 표현하는 여러가지 방법

/*fun invokeLamda(lamda: (Double) -> Boolean) : Boolean{
    return lamda(5.2343)
}*/

fun main(){
   println(square(10))
    var name : String = "chaeyeon"
    var age : Int = 23
    println(nameAge(name, age))

    var a = "bulgogi"
    var b = "cheeze"
    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(ExtendString(name, age))

    /*var lamda : (Double) -> Boolean = {number : Double ->
        number == 4.3214
    }*/
    //println(invokeLamda(lamda))

}
