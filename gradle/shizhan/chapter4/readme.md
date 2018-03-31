##  第四章节


1. 定义简单的task
```
	task test{
		doFirst{

		}

		doLast{

		}
	}

```


2. 定义task 依赖

```
	task dep1 {

	}
	
	task dep2{

	}

	task hello (dependsOn : [dep1,dep2]){  // 注意这里的执行顺序，不确定？

		//do somethings
	}

```
