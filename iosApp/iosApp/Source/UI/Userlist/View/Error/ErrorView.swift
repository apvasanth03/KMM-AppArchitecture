import Foundation
import UIKit

@IBDesignable
class ErrorView: UIView{
    
    // MARK: - Properties.
    @IBInspectable
    var icon: UIImage? = nil{
        didSet{
            setNeedsDisplay()
        }
    }
    @IBInspectable
    var title: String = ""{
        didSet{
            setNeedsDisplay()
        }
    }
    @IBInspectable
    var message: String = ""{
        didSet{
            setNeedsDisplay()
        }
    }
    
    @IBOutlet var contentView: UIView!
    @IBOutlet weak var ivIcon: UIImageView!
    @IBOutlet weak var lTitle: UILabel!
    @IBOutlet weak var lMessage: UILabel!
    
    // MARK: - Init.
    init(icon: UIImage?, title: String, message: String) {
        super.init(frame: CGRect.zero)
        
        self.icon = icon
        self.title = title
        self.message = message
        
        initializeView()
    }
    
    
    // MARK: - UIView Methods.
    override init(frame: CGRect) {
        super.init(frame: frame)
        initializeView()
    }
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        initializeView()
    }
    
    override func draw(_ rect: CGRect) {
        ivIcon.image = icon
        lTitle.text = title
        lMessage.text = message
    }
    
    // MARK: - Private Methods.
    func initializeView(){
        let bundle = Bundle(for: ErrorView.self)
        bundle.loadNibNamed(String(describing: ErrorView.self), owner: self, options: nil)
        
        // Pin the content to the view edges.
        contentView.translatesAutoresizingMaskIntoConstraints = false
        contentView.frame = self.frame
        self.addSubview(contentView)
        contentView.leadingAnchor.constraint(
            equalTo: self.leadingAnchor,
            constant: 0
        ).isActive = true
        contentView.trailingAnchor.constraint(
            equalTo: self.trailingAnchor,
            constant: 0
        ).isActive = true
        contentView.topAnchor.constraint(
            equalTo: self.topAnchor,
            constant: 0
        ).isActive = true
        contentView.bottomAnchor.constraint(
            equalTo: self.bottomAnchor,
            constant: 0
        ).isActive = true
        
    }
}
