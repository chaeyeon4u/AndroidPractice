package com.example.kotlinpractice

//ctrl + 클릭 -> 함수 의미 보기 가능

fun main(){
    //helloWorld()
    //println(add(4, 5))

    //3. String Template
    /*val name = "chaeyeon"
    println("my name is $name")*/

    /*println("is this true? ${1==0}")
    //그냥 $표시 사용하고 싶을 때는 \(역슬래시)사용해~
    println("this is 2\$")
    checkNum(1)*/
    //forAndWhile()
}

//1. function

//Unit은 void와 같다. Unit 안써도 무방
// 리턴형 없을때 사용됨.
fun helloWorld() /*: Unit*/ {
    println("Hello World!");
}

//파라미터, 리턴값 존재
//Int에 I는 대문자.
//당연한 이야기지만 리턴값 있으면 생략 불가능.
//변수명을 타입보다 먼저 작성.
fun add(a: Int, b: Int) : Int {
    return a+b
}

//2. val vs var
//val = value 변할 수 없는 값
//var = variable 변할 수 있는 값
fun h1(){
    val a : Int = 10;
    var b : Int = 9;
    var c = 100;
    val d = 100;

    var name = "유채연"
}

//4. 조건식
//같은 경우!
fun maxBy(a : Int, b: Int) : Int{
    if(a>b){
        return a;
    }else {
        return b;
    }
}
//많이 사용하는 경우!
//코틀린은 삼항연산자 없음 대신 리턴값 이렇게 사용 가능!
fun maxBy2(a: Int, b: Int) : Int = if(a>b) a else b

//5. when!
//when()은 else 무조건 정의해줘야한다.
fun checkNum(score : Int){
    when(score){
        0 -> println("this is 0")
        1,2 -> println("this is 1 or 2")
        else -> println("this is Undefined number")
    }

    //when을 return으로 사용할 때!
    //else 무조건 사용해야한다.
    var b : Int = when(score){
        1-> 1
        2-> 2
        else-> 3
    }

    println(b)

    when(score){
        in 90..100 -> println("Yes Good")
        in 10..89 -> println("Goooood")
        else -> println("Noooooo")
    }
}

//Expression vs Statement
//Array and List
//Array
//List 1. List, 2. Mutablelist

fun array(){
    var array : Array<Int> = arrayOf(1,2,3)
    var list : List<Int> = listOf(1,2,3)

    val array2 : Array<Any> = arrayOf(1,"d", 3.4f)
    val list2 : List<Any> = listOf(1, "d", 3.12)

    array[0] = 3
    //list는 값 변경이 불가하다.
    //list[0] = 1//error

    //Mutablelist(ArrayList!!)
    //ArrayList는 할당된 값의 주소값이 변하지 않아 val(value, 변하지 않는 값)이 될 수 있다!
    val arraylist : ArrayList<Int> = arrayListOf<Int>()
    arraylist.add(10)
    arraylist.add(20)
    arraylist.add(30)
    arraylist.set(1,40)
}

//6. for / while
fun forAndWhile(){
    val students : ArrayList<String> = arrayListOf("chaeyeon", "hwasa", "jenni", "lovely")

    for(name in students){
        println("${name} ")//String Template를 이용하여 출력한다.
    }

    var sum : Int = 0
    for(i in 1..10){//for i는 1부터 10까지
        sum += i
    }
    println(sum)
    sum = 0

    //for i는 1부터 10까지 2씩 증가
    for(i in 1..10 step 2){
        sum += i
    }
    println(sum)
    sum = 0

    // for i는 10부터 0까지
    for(i in 10 downTo 1){
        print("${i} ")
    }

    //until for 1부터 100 미만까지
    for(i in 1 until 100){
        sum += i
    }
    println(sum)
    sum = 0

    //for문에서 Index 사용
    for((index, name) in students.withIndex()){
        println("${index+1}번째 학생입니다. ${name}")
    }

    //while
    var index : Int = 0
    while (index < 100){
        println(index)
        index++
    }
}

//7. Nullable & NonNull
fun nullCheck(){
    // ? -> Nullable type variable
    var nullName : String? = null

    var name = "chaeyeon"
    //대문자로 변환하여 저장
    var nameInUpperCase : String = name.toUpperCase()
    //nullName?.toUpperCase() -> null이면 실행하지 마라
    var nullNameUpperCase : String? = nullName?.toUpperCase()

    //?:
    //default type을 주고싶을 때
    //(lastName?: "No lastname") -> lastName이 null일 경우 "No lastName" 출력하라.
    var lastName : String? = null
    var fullName : String = name+" "+ (lastName?: "No lastname")

    //!! -> null이 아님을 확신시켜주는 코드, 지양해야한다.
}
fun ignoreNulls(str:String?){
    val mNotNull : String = str!!
    val upper : String = mNotNull.toUpperCase()

    //let : email이 null이 아니면 let 다음 스코프를 실행하라.
    val email : String? = "asddff@naver.com"
    email?.let {
        println("my email is ${email}")
    }
}