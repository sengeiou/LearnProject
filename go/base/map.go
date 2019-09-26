package main

import(
  "fmt"
)

/**
1 map的定义 ：var map1 map[keytype]valuetype
        example1： var map1 map[string] string = map[string]string{}
        example2 ：  map2 := map[int]int{}   类型判断
        example3 :  map3 :=  make(map[keytype]valuetype)
2 在申明的时候不需要申明map的长度  map的长度可以动态增加
3 传递参数时，效率没有slice 和数组的 效率高


*/
func main(){


  fmt.Println("go map")


  mapxx := make(map[int]string)
  mapxx2 := map[int]int{}
  mapxx3 := map[int]int{
            1: 1,
            2: 2,
  }

  // 从map 中取值，并判断是否存在
  if value, exists := mapxx3[2] ; exists {
      fmt.Printf("mapxx3 has %d\n", value)
  }

  // 删除map的元素. 不存在的元素不会报错
  delete(mapxx3,1)
  
  fmt.Println(mapxx)
  fmt.Println(mapxx2)
  fmt.Println(mapxx3)

  change(mapxx3)

  // 打印map的长度
  fmt.Println(len(mapxx3))


  var map1 map[string] string = map[string]string{}
  map2 := map[int]int{}
  map3 := make(map[int]int)




  map1["0x"] = "0"
  map1["1x"] = "1"


  map2[0] = 0

  map3[0] = 0


  fmt.Println(map1)
  fmt.Println(map2)
  fmt.Println(map3)

  v :=  map1["01"]
  fmt.Println(v)

  for index,value := range map1 {
      fmt.Println(index, value)
  }



}


// 在函数间传递map时并不会对map 进行拷贝，一旦修改map 所有对map 的引用都会发生变化

func change(names map[int]int){
    delete(names,2)
}
