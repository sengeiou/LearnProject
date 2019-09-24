//
//  ViewController.swift
//  C14
//
//  Created by jun shen on 2019/6/26.
//  Copyright © 2019 jun shen. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UINavigationControllerDelegate, UIImagePickerControllerDelegate {
    @IBOutlet weak var imageview: UIImageView!
    
    @IBAction func camer(_ sender: Any) {
        let imagePicker = UIImagePickerController()
        imagePicker.sourceType = .photoLibrary
        imagePicker.delegate = self
 
        present(imagePicker, animated: true, completion: nil)
    }
    
    
    
    let imgStore = ImageStore()
    
    //MARK: - ACTION
    @IBAction func next(_ sender: Any) {
       
        let sb = UIStoryboard(name: "Main", bundle:nil)
        let vc = sb.instantiateViewController(withIdentifier: "ViewController2") as! ViewController2
        
        self.present(vc, animated: true, completion: nil)
    }
    
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {

       let image =  info[UIImagePickerController.InfoKey.originalImage] as? UIImage
        if let img = image {
            imageview.image = img
            imgStore.setImage(img: img, key: "cocoa")
            
        }
        dismiss(animated: true, completion: nil)
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

