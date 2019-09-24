//
//  ViewController.swift
//  Chapter_1
//
//  Created by jun shen on 2018/12/4.
//  Copyright © 2018 jun shen. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var question: UILabel!
    @IBOutlet weak var amswer: UILabel!
    
    let questions : [String] = [
        "what is 7+ 7?",
        "what is cognac made from?"
    ]
    let answers = [
            "14!",
            "China!"
    ]
    
    var currentQuestionIndex : Int = 0
    
    @IBAction func showNextQuestion(_ sender: Any) {
        currentQuestionIndex += 1
        if currentQuestionIndex == questions.count {
            currentQuestionIndex = 0
        }
        let questionStr = questions[currentQuestionIndex]
        question.text = questionStr
        amswer.text = "???"
    }
    
    @IBAction func showAnswer(_ sender: Any) {
        
        let a = answers[currentQuestionIndex]
        amswer.text = a 
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }


}

