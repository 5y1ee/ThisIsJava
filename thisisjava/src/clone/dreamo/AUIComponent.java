package clone.dreamo;


public abstract class AUIComponent {
	
	public enum UIType {
		NONE,
		POPUP,
		PAGE,
		
	}
	
	protected UIType uiType;
	
	// getter는 필요, setter는 필요없고 constructor에서 하면 될듯..? 아니면 하위 APopup, APage에서 해도 되고.
	public abstract UIType getUIType();
	
	
	// constructor
	public AUIComponent() {
		this.uiType = UIType.NONE;
	}
	
	public AUIComponent(UIType uiType) {
		this.uiType = uiType;
	}
	
	
	
	
	
	
	

}
