for(var i = 0; i < 10; i++){
    setTimeout(()=>{
        console.log(i)
    },100 * i)
}



for(let i = 0; i < 10; i++){
    setTimeout(()=>{
        console.log("use let ="+i);
    }, i * 100)
}



// let 和 const 的区别

