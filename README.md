Hệ thống quản lí gara

-------------Hướng dẫn cài đặt và sử dụng -------------- 
( Chi tiết trong báo cáo ) 

1.Đối tượng, phạm vi sử dụng 
-	Đối tượng sử dụng phần mềm : Quản lí hoặc những người được quản lí cấp phép cho truy cập phần mềm , admin . 
-	Phạm vi sử dụng phần mềm : Dùng trong nội bộ gara . 
2. Xác định yêu cầu cài đặt 
-	Yêu cầu phần mềm : 
+ Có thư viện javaswing , jdbc , jfreechart , itext , apachepoid . 
+ Có IDE lập trình : Neatbean 
+ Cơ sở dữ liệu : MySQL hoặc Xampp
+ Hệ điều hành : Bất cứ hệ điều hành nào 
-	Yêu cầu phần cứng : 
+ Không cần yêu cầu phần cứng có cấu hình cao , dùng được là chạy được 
3. Hưỡng dẫn cài đặt chi tiết 
-	Tải IDE lập trình : Sử dụng Neatbean-IDE https://netbeans.apache.org/front/main/download/nb25/
-	Tải bộ công cụ hỗ trợ lập trình java : JDK21 : https://www.oracle.com/java/technologies/downloads/#jdk21-windows
-	Tải Cơ sở dữ liệu ( Dùng Xampp – dễ dùng , dễ sử dụng ) 
+ Tải phiên bản 8.0.30 : https://www.apachefriends.org/download.html
+ Nễu cổng mặc định khác  3306 thì vào config và đổi 2 cổng sau về 3306

Chú ý : Vào cơ sở dữ liệu , tạo một file dữ liệu có tên là gara , sau đó tải file SQL từ đây : https://drive.google.com/file/d/1ur-Eg1LDjOAn8Y_EoGF1OgzY3yuh38rS/view?usp=sharing
 + Sau khi tải xong , bật Xampp , vào SQL có tên gara , và nhập file dữ liệu vào .
 + Tên đăng nhập pqa123@gmail.com , pass 123 : để chạy
-	Tải thư viện :
+ JDBC ( kết nối và làm việc với csdl ) : https://dev.mysql.com/downloads/connector/j/ hoặc https://drive.google.com/file/d/1No82zgXeWrZetbx7AI60FhKDYIVLOd_U/view?usp=sharing
+ Jfreechart ( vẽ biểu đồ ) – version : 1.0.19 : https://sourceforge.net/projects/jfreechart/files/1.%20JFreeChart/1.0.19/
+ ApachePoid ( xuất , nhập file excel ) – version : 4.0.1 : https://archive.apache.org/dist/poi/release/bin/
+ iText (in file pdf ) – version : 5.5.13 : https://kb.itextpdf.com/it5kb/release-itext-5-5-13
4 : Hướng dẫn sử dụng phần mềm 
-	Phần mềm dùng cho quản lí gara trong phạm vi nội bộ gara .
-	Phần mềm có 5 chức năng chính là : Quản lí nhân viên , Nhận Xe , Thanh Toán , Thống Kê , Quản lí Linh Kiện/ Dịch Vụ 
-	Mỗi chức năng sẽ có các tác vụ khác nhau tùy vào mục đích sử dụng
-	Để sử dụng chức năng nào thì click vào tên của chức năng đó
-	Tài khoản đăng nhập : pqa123@gmail.com   mk : 123
