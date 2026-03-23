**Quyết định:**
-chọn Domain Decomposition.
**Lý do:**
-Khả năng mở rộng: Hệ thống sẽ nhanh chóng phình to nếu thêm tính năng như thanh toán, bài tập, chấm điểm, ... Nếu dùng Technical, thư mục services hay controllers sẽ có thêm hàng chục file rất khó quản lý. Domain giúp dự án gọn gàng bất kể số lượng tính năng tăng lên.

-Khả năng chuyển đổi Microservices: Nếu sau này hệ thống có lượng truy cập lớn và cần tách riêng phần học tập ra khỏi quản lý User, việc cắt cả thư mục courses trong mô hình Domain ra thành một service độc lập sẽ cực kỳ dễ dàng. Với mô hình Technical, việc gỡ rối code để tách service sẽ rất rối và tốn thời gian.

-Cô lập lỗi và làm việc nhóm: Nhiều lập trình viên có thể làm việc song song trên các module/feature khác nhau mà hiếm khi bị xung đột code khi push hay merge.