USE [QuanLyCuaHangXe]
GO
DELETE FROM [dbo].[Xe]
GO
DELETE FROM [dbo].[LinhKien]
GO
DELETE FROM [dbo].[NhaCungCap]
GO
DELETE FROM [dbo].[ChiTietHoaDon]
GO
DELETE FROM [dbo].[HoaDon]
GO
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505041324859', N'KH-002-0004', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 6.05E+07)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042157075', N'KH-002-0001', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 3.202E+08)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042205769', N'KH-002-0008', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 5.6E+08)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042542443', N'KH-002-0003', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 3.2E+07)
INSERT [dbo].[HoaDon] ([MaHD], [MaKH], [MaNV], [NgayLapHoaDon], [TongTien]) VALUES (N'HD20230505042822929', N'KH-002-0015', N'BH-002-0002', CAST(N'2023-05-05T00:00:00.000' AS DateTime), 400000)
GO
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505041324914', N'HD20230505041324859', N'Vinfast05042023H7BR', 1, 2E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505041324918', N'HD20230505041324859', N'Yamaha050020238R48', 1, 4E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505041324919', N'HD20230505041324859', N'LK20230505040758299', 1, 500000)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042157097', N'HD20230505042157075', N'Vinfast05022023DP8E', 20, 1.6E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042157100', N'HD20230505042157075', N'LK20230505040447240', 1, 200000)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042205772', N'HD20230505042205769', N'Yamaha050020238R48', 14, 4E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042542460', N'HD20230505042542443', N'Vinfast05022023DP8E', 2, 1.6E+07)
INSERT [dbo].[ChiTietHoaDon] ([MaCTHD], [MaHD], [MaSP], [SoLuong], [GiaBan]) VALUES (N'CTHD20230505042822951', N'HD20230505042822929', N'LK20230505040447240', 2, 200000)
GO
INSERT [dbo].[NhaCungCap] ([MaNCC], [Ten]) VALUES (N'NCC1', N'Honda')
INSERT [dbo].[NhaCungCap] ([MaNCC], [Ten]) VALUES (N'NCC2', N'Yamaha')
INSERT [dbo].[NhaCungCap] ([MaNCC], [Ten]) VALUES (N'NCC3', N'Vinfast')
GO
INSERT [dbo].[LinhKien] ([MaLinhKien], [MaNCC], [MaCTSuaChua], [TenLinhKien], [ImgPath], [GiaBan], [SoLuongKho], [SoLuongBan]) VALUES (N'LK20230505040447240', N'NCC1', NULL, N'Bugi Xe Máy', N'"path"', 200000, 17, 2)
INSERT [dbo].[LinhKien] ([MaLinhKien], [MaNCC], [MaCTSuaChua], [TenLinhKien], [ImgPath], [GiaBan], [SoLuongKho], [SoLuongBan]) VALUES (N'LK20230505040758299', N'NCC1', NULL, N'Côn Xe Máy', N'"path"', 500000, 9, 1)
GO
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Honda05492023FOQ2', N'NCC1', N'Air Blade', N'Xe Ga', N'Hàn Quốc', 160, N'ME4KF197KK8000001', N'RLHKE081KT010000 đến RLHKE081KT010999', N'Đen', 3E+07, N'"path"', 40, 0)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Honda0555202374L6', N'NCC1', N'Sirius', N'Xe Số', N'Nhật Bản', 100, N'ME4KF257ML8000001 ', N' RLHKE091LK100000', N'Đen', 1.5E+07, N'"path"', 20, 0)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Vinfast05022023DP8E', N'NCC3', N'VinFast Evo200', N'Xe Máy Điện', N'Việt Nam', 120, N'ME4KF151JJ8000001 ', N'RLHKE141MS806999', N'Trắng', 1.6E+07, N'"path"', 28, 2)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Vinfast05042023H7BR', N'NCC3', N'Theon S', N'Xe Máy Điện', N'Việt Nam', 100, N'ME4KF151JJ8005000', N'RLHKE071JJ800000 ', N'Đen', 2E+07, N'"path"', 19, 1)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Yamaha050020238R48', N'NCC2', N'Exciter', N'Xe Số', N'Nhật Bản', 160, N'ME4KF151HH8010000', N'RLHKE071HH810999', N'Xanh Lam', 4E+07, N'"path"', 45, 14)
INSERT [dbo].[Xe] ([MaXe], [MaNCC], [TenXe], [LoaiXe], [NuocSX], [SoPK], [SoKhung], [SoSuon], [MauXe], [Gia], [ImgPath], [SoLuongKho], [SoLuongBan]) VALUES (N'Yamaha050120237SES', N'NCC2', N'Winer', N'Xe Số', N'Hàn Quốc', 180, N'ME4KF197KK8002000', N'RLHKE071HH800000 ', N'Đen', 4.5E+07, N'"path"', 50, 0)
GO
