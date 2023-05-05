USE [QuanLyCuaHangXe]
GO
DELETE FROM [dbo].[KhachHang]
GO
DELETE FROM [dbo].[NhanVien]
GO
DELETE FROM [dbo].[PhongBan]
GO
DELETE FROM [dbo].[DaiLy]
GO
DELETE FROM [dbo].[ChucVu]
GO
SET IDENTITY_INSERT [dbo].[ChucVu] ON 

INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (1, N'Nhân viên quản Lý')
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (2, N'Nhân viên bán hàng')
INSERT [dbo].[ChucVu] ([MaCV], [TenCV]) VALUES (3, N'Nhân viên kĩ thuật')
SET IDENTITY_INSERT [dbo].[ChucVu] OFF
GO
INSERT [dbo].[DaiLy] ([MaDaiLy], [MaKho], [TenDaiLy], [DiaChi]) VALUES (N'2', 1, N'Đại lí 9', N'12 Nguyễn Văn Bảo, Gò Vấp, tp Hồ Chí Minh')
GO
SET IDENTITY_INSERT [dbo].[PhongBan] ON 

INSERT [dbo].[PhongBan] ([MaPB], [MaDaiLy], [TenPB]) VALUES (5, N'2', N'Phòng Kinh Doanh')
INSERT [dbo].[PhongBan] ([MaPB], [MaDaiLy], [TenPB]) VALUES (6, N'2', N'Phòng Kĩ Thuật')
INSERT [dbo].[PhongBan] ([MaPB], [MaDaiLy], [TenPB]) VALUES (7, N'2', N'Phòng Nhân Sự')
SET IDENTITY_INSERT [dbo].[PhongBan] OFF
GO
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'BH-002-0002', 5, 2, N'Võ Ngọc Thắng', CAST(N'2003-12-19T00:00:00.000' AS DateTime), N'0862918261', N'102093826', N'Tp Hồ Chí Minh', N'thangdevweb@github.com', 1, N'Đại học', N'')
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'KT-002-0003', 5, 3, N'Trần Trọng Nhân', CAST(N'2003-07-17T00:00:00.000' AS DateTime), N'0972519251', N'109261091', N'Tỉnh Tiền Giang', N'trantrongnhan11@gmail.com', 1, N'Đại học', N'4')
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'KT-002-0004', 5, 2, N'Dương Văn Phấn', CAST(N'2003-01-01T00:00:00.000' AS DateTime), N'0926172611', N'070203009011', N'Nguyễn Văn Bảo, tp Hồ Chí Minh', N'phandz@gmail.com', 1, N'Đại học', N'')
INSERT [dbo].[NhanVien] ([MaNV], [MaPB], [MaCV], [HoTenNV], [NgaySinh], [SDT], [SoCCCD], [DiaChi], [Email], [GioiTinh], [TrinhDoHocVan], [BacTho]) VALUES (N'QL-002-0001', 5, 2, N'Dương Thái Bảo', CAST(N'2003-12-19T00:00:00.000' AS DateTime), N'0869510030', N'010203008712', N'Bù Đốp, tỉnh Bình Phước', N'bao@1boxstudios.com', 1, N'Đại học', N'')
GO
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0001', N'Dương Thái Bảo', N'Huyện Bù Đốp, tỉnh Bình Phước', N'0869510030', N'285000129', 1, CAST(N'2003-12-19T00:00:00.000' AS DateTime), N'bao@1boxstudios.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0002', N'Trần Trọng Nhân', N'Thị xã Cai Lạy, tỉnh Tiền Giang', N'0943899717', N'273009811', 1, CAST(N'2003-07-17T00:00:00.000' AS DateTime), N'trantrongnhan11@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0003', N'Dương Văn Phấn', N'Gò Vấp, tp Hồ Chí Minh', N'0972600871', N'026726812', 1, CAST(N'2003-01-01T00:00:00.000' AS DateTime), N'phandz@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0004', N'Võ Ngọc Thắng', N'Gò Vấp, tp Hồ Chí Minh', N'0897219211', N'817037182', 1, CAST(N'2003-01-01T00:00:00.000' AS DateTime), N'thangdevweb@github.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0005', N'Võ Hoàng Anh', N'Thị xã Đồng Xoài, Bình Phước', N'0986281621', N'926192124', 1, CAST(N'2000-02-09T00:00:00.000' AS DateTime), N'vohoanganh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0006', N'Phạm Văn Phú', N'Thanh Hoà, tỉnh Bình Phước', N'0862917211', N'972081284', 1, CAST(N'2003-11-25T00:00:00.000' AS DateTime), N'phamvanphu@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0007', N'Trần Thị Yến Nhi', N'Số 14, Nguyễn Văn Công, Thành phố Hồ Chí Minh', N'0899628461', N'926940172', 0, CAST(N'1999-03-09T00:00:00.000' AS DateTime), N'tranyennhi@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0008', N'Võ Trần Quốc Bảo', N'Tỉnh Bình Định', N'0879391621', N'010204007629', 1, CAST(N'2004-08-10T00:00:00.000' AS DateTime), N'quocbao@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0009', N'Phạm Thị Lan Anh', N'Quận 1, tp Hồ Chí Minh', N'0376863999', N'891736281', 0, CAST(N'2002-05-20T00:00:00.000' AS DateTime), N'lananh.depgai@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0010', N'Nguyễn Thị Kim Hoa', N'127 Nguyễn Văn Bảo, Gò Vấp, tp Hồ Chí Minh', N'0728666891', N'209236863', 0, CAST(N'2003-11-24T00:00:00.000' AS DateTime), N'kimhoa.xinh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0011', N'Nguyễn Ngọc Ánh', N'Tỉnh Bình Dương', N'0987618291', N'182936988', 0, CAST(N'1987-10-29T00:00:00.000' AS DateTime), N'nguyenanh@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0012', N'Trần Anh Anh', N'Tp Hồ Chí Minh', N'0987192611', N'827087382', 0, CAST(N'1995-02-09T00:00:00.000' AS DateTime), N'anhanhtran@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0013', N'Quốc Toản', N'Tỉnh Tiền Giang', N'0987261921', N'072972001', 1, CAST(N'2001-08-29T00:00:00.000' AS DateTime), N'toandz@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0014', N'Đỗ Huy Khang', N'Tỉnh Bình Dương', N'0966172228', N'192030309', 1, CAST(N'1994-02-05T00:00:00.000' AS DateTime), N'gayafso2khumaisomot@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0015', N'Vũ Văn Hùng', N'Thanh Hoà, tỉnh Bình Phước', N'0987187877', N'092819281', 1, CAST(N'2004-09-23T00:00:00.000' AS DateTime), N'vuvanhung23@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0016', N'Mai Hồng Hạnh', N'923 Nguyễn Kiệm, tp Hồ Chí Minh', N'0927999523', N'024917201', 0, CAST(N'2001-09-25T00:00:00.000' AS DateTime), N'hanh.xinh.hong@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0017', N'Nguyễn Thu Hà', N'Tỉnh Bình Phước', N'0926391620', N'098729192', 0, CAST(N'1994-05-04T00:00:00.000' AS DateTime), N'hadepgai@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0018', N'Nguyễn Quốc Nam', N'Ấp 10, tỉnh Gia Lai', N'0917972836', N'092638991', 1, CAST(N'1992-02-09T00:00:00.000' AS DateTime), N'quocnam@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0019', N'Trần Kiến Thức', N'120 Nguyễn Thái Sơn, Gò Vấp, tp Hồ Chí Minh', N'0972937777', N'129263927', 1, CAST(N'1992-11-02T00:00:00.000' AS DateTime), N'thuc@gmail.com')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [SoCCCD], [GioiTinh], [NgaySinh], [Email]) VALUES (N'KH-002-0020', N'Nguyễn Thị Nguyệt', N'Tỉnh Gia Lai', N'0817291711', N'108929373', 0, CAST(N'1997-09-12T00:00:00.000' AS DateTime), N'nguyet1997@gmail.com')
GO
