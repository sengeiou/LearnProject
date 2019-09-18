package main

import (
	"fmt"
	"html/template"
	"net/http"
	// "strings"
)

func getUser(w http.ResponseWriter, r *http.Request) {
	fmt.Println("method:", r.Method) //获取请求的方法
	// fmt.Fprintf(w, `{"servers":[{"serverName":"Shanghai_VPN","serverIP":"127.0.0.1"},{"serverName":"Beijing_VPN","serverIP":"127.0.0.2"}]}`)
	fmt.Fprintf(w, `{"serverName":"Shanghai_VPN","serverIP":"127.0.0.1"}`)
}

func login(w http.ResponseWriter, r *http.Request) {
	fmt.Println("method:", r.Method) //获取请求的方法
	if "GET" == r.Method {
		t, _ := template.ParseFiles("login.gtpl")
		t.Execute(w, nil)
	} else {
		r.ParseForm()
		username := r.Form["username"]
		password := r.Form["password"]

		// (s, t string) bool
		if username[0] == "shenjun" && password[0] == "123456" {

			cookie := &http.Cookie{Name: "name", Value: "cocoa", Path: "/", HttpOnly: true, MaxAge: 0}
			http.SetCookie(w, cookie)
			indexTpl, _ := template.ParseFiles("index.gtpl")
			indexTpl.Execute(w, nil)
		}

	}
}

func index(w http.ResponseWriter, r *http.Request) {
	indexTpl, _ := template.ParseFiles("index.gtpl")
	indexTpl.Execute(w, nil)

}

func main() {
	http.HandleFunc("/index", index)
	http.HandleFunc("/getUser", getUser)
	http.HandleFunc("/login", login)
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		fmt.Println("err:", err)
	}
}
