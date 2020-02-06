import React from 'react'
import ReactDom from 'react-dom'


const h1 = React.createElement(
    'h1',
    {class: 'name'}
    ,"h1 h1 h1"
)

const parent = document.getElementById("app")

ReactDom.render(h1,parent)

