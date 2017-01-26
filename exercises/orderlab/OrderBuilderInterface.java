package exercises.orderlab;

public interface OrderBuilderInterface {

	void setItem(Item item);
	void setDiscount(Item discount);
	Order build();

}
