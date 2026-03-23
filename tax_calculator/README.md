**Chọn Decorator là phù hợp nhất:**
1. Yêu cầu chính: áp dụng nhiều loại thuế cùng lúc
2. Decorator cho phép kết hợp linh hoạt các thuế theo dạng composition
3. Dễ thêm loại thuế mới (VatTaxDecorator, ExciseTaxDecorator, ...)
4. Không cần sửa BaseAmount hay các decorator cũ

**Lý do không chọn các pattern khác:**
- **State:** Thiên về 1 trạng thái hoạt động. Không tự nhiên khi áp dụng nhiều thuế.
- **Strategy:** Chỉ chọn 1 thuế tại 1 lúc. Không hỗ trợ "cộng dồn" nhiều thuế.

## Trade-off

- **Decorator:** Khi xếp quá nhiều lớp, code khó theo dõi. Cần quy ước thứ tự rõ ràng.
- **State/Strategy:** Đơn giản hơn nhưng không đáp ứng yêu cầu áp dụng nhiều thuế.
