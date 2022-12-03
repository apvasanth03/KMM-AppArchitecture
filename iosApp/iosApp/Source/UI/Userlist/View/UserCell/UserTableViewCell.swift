//
//  UserTableViewCell.swift
//  iOS-AppArchitecture
//
//  Created by Vasanthakumar Annadurai on 31/10/22.
//

import UIKit
import shared

class UserTableViewCell: UITableViewCell {
    
    // MARK: - Properties.
    static let IDENTIFIER = "UserTableViewCell"
    
    @IBOutlet weak var lName: UILabel!
    @IBOutlet weak var lEmail: UILabel!
    
    // MARK: - UITableViewCell Methods.
    override func awakeFromNib() {
        super.awakeFromNib()
        
        initializeCell()
    }
    
    // MARK: - Public Methods.
    func populateCell(user: UserUIModel){
        lName.text = user.name
        lEmail.text = user.email
    }
    
    
    // MARK: - Private Methods.
    private func initializeCell(){
        self.selectionStyle = .none
    }
}
