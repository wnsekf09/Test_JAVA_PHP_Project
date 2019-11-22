package test;

public class FlowerDTO {
	private int cod;
	private String category;
	private String product;
	private String ops;
	private String unit;
	private int wearing;
	private int shipping;
	private int wcount;
	private int scount;
	private int stock;
	private String del;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getOps() {
		return ops;
	}
	public void setOps(String ops) {
		this.ops = ops;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getWearing() {
		return wearing;
	}
	public void setWearing(int wearing) {
		this.wearing = wearing;
	}
	public int getShipping() {
		return shipping;
	}
	public void setShipping(int shipping) {
		this.shipping = shipping;
	}
	public int getWcount() {
		return wcount;
	}
	public void setWcount(int wcount) {
		this.wcount = wcount;
	}
	public int getScount() {
		return scount;
	}
	public void setScount(int scount) {
		this.scount = scount;
	}
	public int getStock() {
		stock= wcount - scount;
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public FlowerDTO() {
	
		// TODO Auto-generated constructor stub
	}
	public FlowerDTO(int cod, String category, String product, String ops, String unit, int wearing, int shipping,
			int wcount, int scount, int stock, String del) {
		this.cod = cod;
		this.category = category;
		this.product = product;
		this.ops = ops;
		this.unit = unit;
		this.wearing = wearing;
		this.shipping = shipping;
		this.wcount = wcount;
		this.scount = scount;
		this.stock = stock;
		this.del = del;
	}
	@Override
	public String toString() {
		return "FlowerDTO [cod=" + cod + ", category=" + category + ", product=" + product + ", ops=" + ops + ", unit="
				+ unit + ", wearing=" + wearing + ", shipping=" + shipping + ", wcount=" + wcount + ", scount=" + scount
				+ ", stock=" + stock + ", del=" + del + "]";
	}
	
	
	
	
}