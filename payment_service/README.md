**Dùng cả 3 pattern**

### 1. State Pattern

Quản lý vòng đời thanh toán:

* Điều khiển trạng thái: Unpaid → Processing → Completed / Failed
* Mỗi trạng thái giới hạn hành vi hợp lệ

### 2. Strategy Pattern

Xử lý phương thức thanh toán:

* Cho phép chọn Credit Card, PayPal tại runtime
* Dễ mở rộng thêm phương thức mới

### 3. Decorator Pattern

Tính toán số tiền:

* Thêm phí xử lý
* Áp dụng giảm giá
* Có thể kết hợp nhiều lớp decorator
