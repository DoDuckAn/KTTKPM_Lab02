**State pattern là tốt nhất:**
1. Đơn hàng có vòng đời rõ ràng: NEW → PROCESSING → DELIVERED
2. Không phải tất cả transition đều hợp lệ (ví dụ: không thể từ DELIVERED quay lại NEW)
3. Mỗi trạng thái có hành vi riêng không liên quan với các state khác
4. State tự biết state tiếp theo là gì

## Trade-off

- **State:** Tăng số class (5 class state), cần thiết kế transition cẩn thận
- **Strategy:** Code đơn giản nhưng logic chuyển trạng thái bị phân tán hoặc phải quản lý manual
- **Decorator:** Rất mạnh thêm feature nhưng thứ tự xếp chồng rất quan trọng và khó debug
