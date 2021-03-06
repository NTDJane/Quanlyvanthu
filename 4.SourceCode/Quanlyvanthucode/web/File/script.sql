USE [master]
GO
/****** Object:  Database [NhaHang]    Script Date: 10/18/2017 12:30:35 AM ******/
CREATE DATABASE [NhaHang]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'NhaHang', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MAYCHU\MSSQL\DATA\NhaHang.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'NhaHang_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MAYCHU\MSSQL\DATA\NhaHang_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [NhaHang] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [NhaHang].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [NhaHang] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [NhaHang] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [NhaHang] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [NhaHang] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [NhaHang] SET ARITHABORT OFF 
GO
ALTER DATABASE [NhaHang] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [NhaHang] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [NhaHang] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [NhaHang] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [NhaHang] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [NhaHang] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [NhaHang] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [NhaHang] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [NhaHang] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [NhaHang] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [NhaHang] SET  DISABLE_BROKER 
GO
ALTER DATABASE [NhaHang] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [NhaHang] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [NhaHang] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [NhaHang] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [NhaHang] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [NhaHang] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [NhaHang] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [NhaHang] SET RECOVERY FULL 
GO
ALTER DATABASE [NhaHang] SET  MULTI_USER 
GO
ALTER DATABASE [NhaHang] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [NhaHang] SET DB_CHAINING OFF 
GO
ALTER DATABASE [NhaHang] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [NhaHang] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'NhaHang', N'ON'
GO
USE [NhaHang]
GO
/****** Object:  StoredProcedure [dbo].[SP_ALLMon]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_ALLMon]	
	
AS
BEGIN
	Select * from [mon an]
END

GO
/****** Object:  StoredProcedure [dbo].[SP_DeleteNV]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_DeleteNV]
	@IDNV int
AS
BEGIN
	delete from [user] where ID=@IDNV
END

GO
/****** Object:  StoredProcedure [dbo].[SP_DONHANG]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_DONHANG]
	
AS
BEGIN
	select* from [don hang]
END

GO
/****** Object:  StoredProcedure [dbo].[SP_GetNhanvien]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE  [dbo].[SP_GetNhanvien]
	
AS
BEGIN
	select* from [user]
END

GO
/****** Object:  StoredProcedure [dbo].[SP_InsertNhanVien]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_InsertNhanVien]
	
	@Hoten nvarchar(255),
	@User nvarchar(255),
	@pass nvarchar(255),
	@role int
AS
BEGIN
	insert into [user]([Ho Ten],username,password,role)
	values(@Hoten,@User,@pass,@role)
END

GO
/****** Object:  StoredProcedure [dbo].[SP_NHANDONHANGBYID]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_NHANDONHANGBYID]
	@IDDonhang int
AS
BEGIN
	select * from [don hang] where ID=@IDDonhang
END

GO
/****** Object:  StoredProcedure [dbo].[SP_THEMDONHANG]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_THEMDONHANG]
	 @ID int	,
	 @Hoten nvarchar(255),
	 @DiaChi nvarchar(255),
	 @SDT int,
	 @Ngaylap date,
	 @Tongtien decimal(10,2),
	 @Trangthai int
AS
BEGIN
	insert into [don hang](ID,[Ho ten KH],[Dia chi],SDT,[Ngay lap],[Tong tien],[Trang thai])
	values (@ID,@Hoten,@DiaChi,@SDT,@Ngaylap,@Tongtien,@Trangthai)
END

GO
/****** Object:  StoredProcedure [dbo].[SP_Themmon]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_Themmon]
	@Tenmon nvarchar(255),
	@Gia nvarchar(255),
	@Hinh nvarchar(255),
	@Mota nvarchar(255)
AS
BEGIN
	insert into [mon an] (TenMon,Gia,Hinh,Mota) values (@Tenmon,@Gia,@Hinh,@Mota)
END

GO
/****** Object:  StoredProcedure [dbo].[SP_UpdateNV]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_UpdateNV]
	@IDNV int,
	@Hoten nvarchar(255),
	@User nvarchar(255),
	@pass nvarchar(255),
	@role int
AS
BEGIN
	update [user] set [Ho Ten]=@Hoten,username=@User,password=@pass,role=@role
	where ID=@IDNV;
	
END

GO
/****** Object:  StoredProcedure [dbo].[SP_XoaMon]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SP_XoaMon]
	@IDMon int
AS
BEGIN
	delete from [mon an] where ID=@IDMon
END

GO
/****** Object:  StoredProcedure [dbo].[SPGetNVID]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[SPGetNVID]
	@IDNV int 
AS
BEGIN
	select * from [user] where [user].ID=@IDNV
END

GO
/****** Object:  Table [dbo].[chi tiet don hang]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[chi tiet don hang](
	[ID] [int] IDENTITY(0,1) NOT NULL,
	[ID don hang] [int] NOT NULL,
	[ID mon an] [int] NOT NULL,
	[So luong] [varchar](54) NOT NULL,
	[Gia] [decimal](10, 2) NOT NULL,
 CONSTRAINT [PK_chi tiet don hang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[don hang]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[don hang](
	[ID] [int] IDENTITY(0,1) NOT NULL,
	[Ho ten KH] [varchar](255) NOT NULL,
	[Dia chi] [varchar](255) NOT NULL,
	[SDT] [int] NOT NULL,
	[Ngay lap] [date] NOT NULL,
	[Tong tien] [decimal](10, 2) NOT NULL,
	[Trang thai] [int] NOT NULL,
 CONSTRAINT [PK_don hang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[loai mon an]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[loai mon an](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ten loai] [varchar](255) NOT NULL,
 CONSTRAINT [PK_loai mon an] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[mon an]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[mon an](
	[ID] [int] IDENTITY(0,1) NOT NULL,
	[IDLoaiMonAn] [int] NOT NULL,
	[TenMon] [varchar](255) NOT NULL,
	[Gia] [decimal](10, 2) NOT NULL,
	[Hinh] [varchar](255) NULL,
	[Mota] [varchar](255) NULL,
 CONSTRAINT [PK_mon an] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[role]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[role](
	[ID] [int] NOT NULL,
	[Ten Quyen] [varchar](45) NULL,
 CONSTRAINT [PK_role] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user]    Script Date: 10/18/2017 12:30:35 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user](
	[ID] [int] IDENTITY(0,1) NOT NULL,
	[Ho Ten] [varchar](255) NOT NULL,
	[username] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[don hang] ON 

INSERT [dbo].[don hang] ([ID], [Ho ten KH], [Dia chi], [SDT], [Ngay lap], [Tong tien], [Trang thai]) VALUES (0, N'Tu', N'HaNoi', 12315, CAST(0x443D0B00 AS Date), CAST(199090.00 AS Decimal(10, 2)), 1)
SET IDENTITY_INSERT [dbo].[don hang] OFF
SET IDENTITY_INSERT [dbo].[loai mon an] ON 

INSERT [dbo].[loai mon an] ([ID], [Ten loai]) VALUES (1, N'chien')
INSERT [dbo].[loai mon an] ([ID], [Ten loai]) VALUES (2, N'luong')
SET IDENTITY_INSERT [dbo].[loai mon an] OFF
SET IDENTITY_INSERT [dbo].[mon an] ON 

INSERT [dbo].[mon an] ([ID], [IDLoaiMonAn], [TenMon], [Gia], [Hinh], [Mota]) VALUES (4, 2, N'ca', CAST(14000.00 AS Decimal(10, 2)), N'a,ndl', N'alkdfja')
INSERT [dbo].[mon an] ([ID], [IDLoaiMonAn], [TenMon], [Gia], [Hinh], [Mota]) VALUES (5, 1, N'asf', CAST(12.00 AS Decimal(10, 2)), N'asdf', N'adf')
SET IDENTITY_INSERT [dbo].[mon an] OFF
INSERT [dbo].[role] ([ID], [Ten Quyen]) VALUES (0, N'Nhan vien')
INSERT [dbo].[role] ([ID], [Ten Quyen]) VALUES (1, N'Quan tri')
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([ID], [Ho Ten], [username], [password], [role]) VALUES (1, N'qwer', N'qwe', N'232', 1)
INSERT [dbo].[user] ([ID], [Ho Ten], [username], [password], [role]) VALUES (3, N'THy', N'askdjf', N'870', 0)
INSERT [dbo].[user] ([ID], [Ho Ten], [username], [password], [role]) VALUES (4, N'Trung', N'Hai', N'324', 0)
INSERT [dbo].[user] ([ID], [Ho Ten], [username], [password], [role]) VALUES (5, N'ksi', N' nfba', N'1214', 1)
INSERT [dbo].[user] ([ID], [Ho Ten], [username], [password], [role]) VALUES (6, N'Trung', N'dsa', N'21231', 1)
SET IDENTITY_INSERT [dbo].[user] OFF
ALTER TABLE [dbo].[don hang] ADD  CONSTRAINT [DF_don hang_Trang thai]  DEFAULT ((0)) FOR [Trang thai]
GO
ALTER TABLE [dbo].[chi tiet don hang]  WITH CHECK ADD  CONSTRAINT [FK_chi tiet don hang_don hang] FOREIGN KEY([ID don hang])
REFERENCES [dbo].[don hang] ([ID])
GO
ALTER TABLE [dbo].[chi tiet don hang] CHECK CONSTRAINT [FK_chi tiet don hang_don hang]
GO
ALTER TABLE [dbo].[chi tiet don hang]  WITH CHECK ADD  CONSTRAINT [FK_chi tiet don hang_mon an] FOREIGN KEY([ID mon an])
REFERENCES [dbo].[mon an] ([ID])
GO
ALTER TABLE [dbo].[chi tiet don hang] CHECK CONSTRAINT [FK_chi tiet don hang_mon an]
GO
ALTER TABLE [dbo].[mon an]  WITH CHECK ADD  CONSTRAINT [FK_mon an_loai mon an] FOREIGN KEY([IDLoaiMonAn])
REFERENCES [dbo].[loai mon an] ([ID])
GO
ALTER TABLE [dbo].[mon an] CHECK CONSTRAINT [FK_mon an_loai mon an]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_user_role1] FOREIGN KEY([role])
REFERENCES [dbo].[role] ([ID])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FK_user_role1]
GO
USE [master]
GO
ALTER DATABASE [NhaHang] SET  READ_WRITE 
GO
