import scala.util.parsing.json.JSON


val result = JSON.parseFull("""
  {"name": "Naoki",  "lang": ["Java", "Scala"]}
""")

var a = result.get

var b = a.asInstanceOf[Map[String,String]]
var list : List[String] = b("lang").asInstanceOf[List[String]]

println(list.head)
