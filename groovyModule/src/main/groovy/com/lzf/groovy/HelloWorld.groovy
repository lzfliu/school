package com.lzf.groovy

import com.lzf.groovy.entity.User

/**
 * 描述:
 * 第一个groovy代码
 *
 * @outhor liuzhenfei
 * @create 2017-09-18 上午 10:14
 */
class HelloWorld {

    /**
     * @param args
     */
    static void main(def args){
        // TODO Auto-generated method stub
        println "Hello World"

       // groovy4String()

       // groovy4LeiXing()

        groovy4XunHuan()

        //groovy4Object()


    }

    private static void groovy4Collection() {

        def collect=["a","b","c"]
        //除了声明时往集合中添加元素外，还可以用以下方式向集合中添加元素：
        collect.add(1);
        collect<<"come on";
        collect[collect.size()]=100.0
        //Collection使用类似数组下标的方式进行检索：
        println collect[collect.size()-1]
        println collect[5]
        //groovy支持负索引：
        println collect[-1]      //索引其倒数第1个元素
        println collect[-2]      //索引其倒数第2个元素
        //Collection支持集合运算：
        collect=collect+5        //在集合中添加元素5
        println collect[collect.size()-1]
        collect=collect-'a'         //在集合中减去元素a(第1个)
        println collect[0]          //现在第1个元素变成b了
        //同样地，你可以往集合中添加另一个集合或删除一个集合：
        collect=collect-collect[0..4]   //把集合中的前5个元素去掉
        println collect[0]   //现在集合中仅有一个元素，即原来的最后一个元素
        println collect[-1]  //也可以用负索引，证明最后一个元素就是第一个元素
    }
    
    private static void groovy4XunHuan() {

        def var="hello "+
                "world"+
                ",groovy!"

        for(def i = 0; i < 5; i++){
            println var
        }

    }



    private static void groovy4String() {
        def var = """select
                    *
                  from 表 
                  where 条件=？"""
        println var
    }
    private static void groovy4LeiXing() {
        def var="hello "+
                "world"+
                ",groovy!"
        println var
        println var.class
        var=1001
        println var
        println var.class
    }

    private static void groovy4Object() {
        User user = new User(['username': '张三', 'age': 20, 'adress': '城阳区'])
        /*  user.adress = "李四"
          user.age = 20
          user.username = "城阳区仲村"*/
        println user.username + "   " + user.age + "    " + user.adress
    }

}
