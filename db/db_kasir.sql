-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2017 at 01:24 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kasir`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kode_barang` bigint(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `id_kategori` int(5) NOT NULL,
  `harga` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama`, `id_kategori`, `harga`) VALUES
(1, 'Jilid Terusan Hitam/ Putih', 4, 4000),
(2, 'Jilid Terusan Warna', 4, 5000),
(3, 'Jilid Mika', 4, 3000),
(4, 'Print A4 Warna ', 2, 500),
(5, 'Print A4 Hitam/ Putih', 2, 250),
(6, 'Print A3 Warna', 2, 5000),
(7, 'Fotokopi A4', 3, 200),
(8, 'Fotokopi A3', 3, 800),
(9, 'Fotokopi A4 Bufallow', 3, 1200),
(10, 'Folio Bergaris', 1, 250),
(11, 'Stofmap Folio', 1, 1500),
(12, 'Map Plastik', 1, 2500),
(13, 'Map Kancing', 1, 3500),
(14, 'Bulpen Snowman V5', 1, 3000),
(15, 'Stabillo', 1, 6000),
(16, 'Buku Tulis Sidu 38', 1, 3500),
(17, 'Loose Leaf A4 isi 50', 1, 4500),
(18, 'Spidol Snowman Boardmarker', 1, 8000),
(19, 'Lem UHU', 1, 7000),
(20, 'Pensil Stadler 2B', 1, 3000);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_transaksi` bigint(10) NOT NULL,
  `kode_barang` bigint(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `faktur`
--

CREATE TABLE `faktur` (
  `id_faktur` bigint(10) NOT NULL,
  `nomer_faktur` bigint(10) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faktur`
--

INSERT INTO `faktur` (`id_faktur`, `nomer_faktur`, `tanggal`) VALUES
(1, 12345, '2017-06-07'),
(2, 123456789, '2017-07-23'),
(3, 55555, '2017-07-23');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama`) VALUES
(1, 'ATK'),
(2, 'Print'),
(3, 'Fotokopi'),
(4, 'Jasa');

-- --------------------------------------------------------

--
-- Table structure for table `pembelian`
--

CREATE TABLE `pembelian` (
  `id_pembelian` bigint(10) NOT NULL,
  `id_faktur` bigint(10) NOT NULL,
  `id_suplier` int(5) NOT NULL,
  `tanggal` date NOT NULL,
  `jumlah_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembelian`
--

INSERT INTO `pembelian` (`id_pembelian`, `id_faktur`, `id_suplier`, `tanggal`, `jumlah_harga`) VALUES
(1, 1, 1, '2017-07-23', 1000000),
(2, 2, 2, '2017-07-23', 500000),
(3, 3, 1, '2017-07-18', 1000000),
(4, 3, 2, '2017-07-10', 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `suplier`
--

CREATE TABLE `suplier` (
  `id_suplier` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `no_telp` bigint(15) NOT NULL,
  `bank` varchar(20) NOT NULL,
  `nomor_rekening` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suplier`
--

INSERT INTO `suplier` (`id_suplier`, `nama`, `alamat`, `no_telp`, `bank`, `nomor_rekening`) VALUES
(1, 'Wahyu Nugraha', 'Simo, Boyolali	', 85728757832, 'Mandiri', 123456789),
(2, 'Liliana Desi Ragitasari', 'Mandiraja Wetan, Banjarnegara	', 85222333555, 'BRI', 987654321);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` bigint(10) NOT NULL,
  `kode_transaksi` int(11) NOT NULL,
  `nama_kasir` varchar(30) NOT NULL,
  `tanggal` date NOT NULL,
  `harga_barang` int(8) NOT NULL,
  `jumlah_barang` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `kode_transaksi`, `nama_kasir`, `tanggal`, `harga_barang`, `jumlah_barang`) VALUES
(1, 1, 'Wahyu', '2017-07-22', 10000, 1),
(2, 1, 'Wahyu', '2017-07-22', 10000, 1),
(3, 2, 'Wahyu', '2017-07-22', 10000, 1),
(4, 2, 'Wahyu', '2017-07-22', 20000, 2),
(5, 2, 'Wahyu', '2017-07-22', 20000, 10),
(6, 3, 'Wahyu', '2017-07-22', 50000, 5),
(7, 4, 'Wahyu', '2017-07-25', 10000, 1),
(8, 4, 'Wahyu', '2017-07-25', 50000, 5),
(9, 5, 'Wahyu', '2017-07-25', 10000, 1),
(10, 5, 'Wahyu', '2017-07-25', 50000, 5),
(11, 5, 'Wahyu', '2017-07-25', 10000, 1),
(12, 5, 'Wahyu', '2017-07-25', 34000, 2),
(13, 5, 'Wahyu', '2017-07-25', 10000, 10),
(14, 6, 'Wahyu', '2017-07-25', 10000, 1),
(15, 6, 'Wahyu', '2017-07-25', 20000, 2),
(16, 6, 'Wahyu', '2017-07-25', 10000, 5),
(17, 6, 'Wahyu', '2017-07-25', 4000, 2),
(18, 6, 'Wahyu', '2017-07-25', 17000, 1),
(19, 6, 'Wahyu', '2017-07-25', 1000, 1),
(20, 7, 'Wahyu', '2017-07-25', 10000, 10),
(21, 7, 'Wahyu', '2017-07-25', 10000, 1),
(22, 7, 'Wahyu', '2017-07-25', 10000, 2),
(23, 7, 'Wahyu', '2017-07-25', 10000, 5),
(24, 8, 'Wahyu', '2017-07-26', 10000, 1),
(25, 9, 'Wahyu', '2017-07-26', 10000, 1),
(26, 10, 'Wahyu', '2017-07-26', 10000, 1),
(27, 11, 'Wahyu', '2017-07-26', 10000, 1),
(28, 12, 'Wahyu', '2017-07-26', 10000, 1),
(29, 12, 'Wahyu', '2017-07-26', 10000, 1),
(30, 13, 'Wahyu', '2017-07-26', 10000, 1),
(31, 13, 'Wahyu', '2017-07-26', 10000, 1),
(32, 13, 'Wahyu', '2017-07-26', 10000, 1),
(33, 13, 'Wahyu', '2017-07-26', 10000, 5),
(34, 14, 'Wahyu', '2017-07-27', 10000, 1),
(35, 15, 'Wahyu', '2017-07-27', 40000, 4),
(36, 15, 'Wahyu', '2017-07-27', 10000, 5),
(37, 16, 'admin', '2017-12-12', 1000, 1),
(38, 16, 'admin', '2017-12-12', 2000, 1),
(39, 16, 'admin', '2017-12-12', 2000, 1),
(40, 17, 'admin', '2017-12-12', 10000, 1),
(41, 18, 'admin', '2017-12-13', 5000, 1),
(42, 19, 'kasir', '2017-12-13', 10000, 1),
(43, 20, 'admin', '2017-12-13', 1000, 1),
(44, 20, 'admin', '2017-12-13', 10000, 1),
(45, 21, '', '2017-12-13', 10000, 1),
(46, 22, '', '2017-12-13', 5000, 1),
(47, 23, '', '2017-12-13', 10000, 1),
(48, 23, '', '2017-12-13', 10000, 1),
(49, 23, '', '2017-12-13', 10000, 1),
(50, 23, '', '2017-12-13', 10000, 1),
(51, 24, '', '2017-12-13', 10000, 1),
(52, 24, '', '2017-12-13', 10000, 1),
(53, 24, '', '2017-12-13', 10000, 2),
(54, 25, 'ADMIN', '2017-12-13', 40000, 4),
(55, 26, '', '2017-12-13', 10000, 1),
(56, 26, '', '2017-12-13', 10000, 1),
(57, 27, 'admin', '2017-12-13', 10000, 1),
(58, 27, 'admin', '2017-12-13', 10000, 5),
(59, 28, '', '2017-12-13', 10000, 1),
(60, 28, '', '2017-12-13', 10000, 5),
(61, 29, '', '2017-12-13', 10000, 5),
(62, 30, '', '2017-12-13', 50000, 5),
(63, 31, 'admin', '2017-12-13', 22222, 1),
(64, 31, 'admin', '2017-12-13', 5000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(5) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `level` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `level`) VALUES
(1, 'admin', 'admin', 'Admin'),
(2, 'Wahyu', 'wahyu', 'Admin'),
(3, 'kasir', 'kasir', 'Kasir'),
(4, 'ari', 'ari', 'Admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`),
  ADD KEY `barang_ibfk_1` (`id_kategori`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `kode_barang` (`kode_barang`);

--
-- Indexes for table `faktur`
--
ALTER TABLE `faktur`
  ADD PRIMARY KEY (`id_faktur`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD PRIMARY KEY (`id_pembelian`),
  ADD KEY `pembelian_ibfk_1` (`id_faktur`),
  ADD KEY `pembelian_ibfk_2` (`id_suplier`);

--
-- Indexes for table `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`id_suplier`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`kode_barang`) REFERENCES `barang` (`kode_barang`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembelian`
--
ALTER TABLE `pembelian`
  ADD CONSTRAINT `pembelian_ibfk_1` FOREIGN KEY (`id_faktur`) REFERENCES `faktur` (`id_faktur`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pembelian_ibfk_2` FOREIGN KEY (`id_suplier`) REFERENCES `suplier` (`id_suplier`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
