import com.walmart.api.coupon.models.Coupon;
import com.walmart.api.dao.impl.CouponJpaDaoImpl;

public class CouponApplication{
	public static void main(String[] args) {
		Coupon coupon = new Coupon();
		coupon.setCouponCode("id");
		coupon.setDiscount(50);
		
		CouponJpaDaoImpl dao= new CouponJpaDaoImpl();
		dao.saveCoupon(coupon);
	}
}