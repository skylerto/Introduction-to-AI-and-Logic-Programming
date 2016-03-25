package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import astar.Path;

/**
 * A* Algorithm Implementation in Java using the Manhatten Heuristic of integer
 * index.
 * 
 * @author Skyler Layne © 2016
 *
 */
public class Main {

	public static void main(String[] args) {

		// Define Start and End Indexes
		// int start = 8;
		// int end = 0;

		// Define the Graph
		// List<Integer> graph = new ArrayList<Integer>(Arrays.asList(0, 1, 1,
		// 5, 100, 100, 1, 1, 0));

		// Define the Adj Matrix
		// Map<Integer, List<Integer>> adj = new HashMap<Integer,
		// List<Integer>>();
		// adj.put(0, new ArrayList<Integer>(Arrays.asList(1, 3)));
		// adj.put(1, new ArrayList<Integer>(Arrays.asList(0, 2)));
		// adj.put(2, new ArrayList<Integer>(Arrays.asList(1)));
		// adj.put(3, new ArrayList<Integer>(Arrays.asList(0, 6)));
		// adj.put(4, new ArrayList<Integer>());
		// adj.put(5, new ArrayList<Integer>());
		// adj.put(6, new ArrayList<Integer>(Arrays.asList(3, 7)));
		// adj.put(7, new ArrayList<Integer>(Arrays.asList(6, 8)));
		// adj.put(8, new ArrayList<Integer>(Arrays.asList(7)));

		/* MARS */
		int start = 8; // A
		int end = 0; // B or C
		List<Integer> graph = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 3, 1, 1, 1, 2, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2, 2, 2,
				2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 4, 3, 3, 3, 3, 3, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 2, 2, 2, 1, 1,
				1, 1, 2, 2, 2, 3, 2, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 2, 3, 3, 3, 3, 3, 1, 3, 3, 2, 1, 2, 1, 2,
				2, 2, 3, 3, 2, 2, 3, 3, 3, 3, 4, 3, 3, 3, 3, 2, 2, 1, 1, 1, 1, 4, 4, 3, 2, 3, 2, 1, 1, 4, 4, 1, 1, 1, 1,
				3, 3, 2, 2, 3, 1, 1, 2, 2, 4, 4, 4, 2, 2, 2, 2, 3, 3, 3, 1, 2, 3, 3, 2, 1, 1, 1, 1, 2, 2, 1, 1, 3, 3, 3,
				2, 2, 1, 2, 1, 1, 2, 2, 1, 3, 5, 4, 1, 1, 2, 1, 1, 1, 3, 2, 1, 1, 1, 1, 1, 2, 3, 4, 2, 2, 2, 1, 3, 3, 1,
				2, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1, 1, 2, 1, 1, 2, 2, 1, 3, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1,
				1, 1, 1, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 3, 2, 2, 2, 1, 1, 1, 1, 2, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 3, 2, 2,
				2, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 2, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 2, 1, 1, 2, 1, 3, 2, 1, 2, 1, 1, 1,
				1, 1, 1, 3, 3, 3, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 3, 3, 2, 2, 1, 1, 1, 1, 1, 3, 3,
				3, 3, 3, 1, 1, 1, 1, 2, 3, 2, 2, 4, 4, 4, 2, 2, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 3, 3, 3, 3, 2, 2,
				1, 1, 2, 2, 2, 1, 1, 3, 4, 4, 4, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 2, 2, 1, 1, 2, 1, 1, 1,
				1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 2, 2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 1));

		Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();

		/* ROW 0 */
		adj.put(0, new ArrayList<Integer>(Arrays.asList(1, 32)));
		adj.put(1, new ArrayList<Integer>(Arrays.asList(9, 2, 33)));
		adj.put(2, new ArrayList<Integer>(Arrays.asList(1, 3, 34)));
		adj.put(3, new ArrayList<Integer>(Arrays.asList(2, 4, 35)));
		adj.put(4, new ArrayList<Integer>(Arrays.asList(3, 5, 36)));
		adj.put(5, new ArrayList<Integer>(Arrays.asList(4, 6, 37)));
		adj.put(6, new ArrayList<Integer>(Arrays.asList(5, 7, 38)));
		adj.put(7, new ArrayList<Integer>(Arrays.asList(6, 8, 39)));
		adj.put(8, new ArrayList<Integer>(Arrays.asList(7, 9, 40)));
		adj.put(9, new ArrayList<Integer>(Arrays.asList(8, 10, 41)));
		adj.put(10, new ArrayList<Integer>(Arrays.asList(9, 11, 42)));
		adj.put(11, new ArrayList<Integer>(Arrays.asList(10, 12, 43)));
		adj.put(12, new ArrayList<Integer>(Arrays.asList(11, 13, 44)));
		adj.put(13, new ArrayList<Integer>(Arrays.asList(12, 14, 45)));
		adj.put(14, new ArrayList<Integer>(Arrays.asList(13, 15, 46)));
		adj.put(15, new ArrayList<Integer>(Arrays.asList(14, 16, 47)));
		adj.put(16, new ArrayList<Integer>(Arrays.asList(15, 17, 48)));
		adj.put(17, new ArrayList<Integer>(Arrays.asList(16, 18, 49)));
		adj.put(18, new ArrayList<Integer>(Arrays.asList(17, 19, 50)));
		adj.put(19, new ArrayList<Integer>(Arrays.asList(18, 20, 51)));
		adj.put(20, new ArrayList<Integer>(Arrays.asList(19, 21, 52)));
		adj.put(21, new ArrayList<Integer>(Arrays.asList(20, 22, 53)));
		adj.put(22, new ArrayList<Integer>(Arrays.asList(21, 23, 54)));
		adj.put(23, new ArrayList<Integer>(Arrays.asList(22, 24, 55)));
		adj.put(24, new ArrayList<Integer>(Arrays.asList(23, 25, 56)));
		adj.put(25, new ArrayList<Integer>(Arrays.asList(24, 26, 57)));
		adj.put(26, new ArrayList<Integer>(Arrays.asList(25, 27, 58)));
		adj.put(27, new ArrayList<Integer>(Arrays.asList(26, 28, 59)));
		adj.put(28, new ArrayList<Integer>(Arrays.asList(27, 29, 60)));
		adj.put(29, new ArrayList<Integer>(Arrays.asList(28, 30, 61)));
		adj.put(30, new ArrayList<Integer>(Arrays.asList(29, 31, 62)));
		adj.put(31, new ArrayList<Integer>(Arrays.asList(30, 63)));

		/* ROW 1 */
		adj.put(32, new ArrayList<Integer>(Arrays.asList(0, 33, 64)));
		adj.put(33, new ArrayList<Integer>(Arrays.asList(1, 32, 34, 65)));
		adj.put(34, new ArrayList<Integer>(Arrays.asList(2, 33, 35, 66)));
		adj.put(35, new ArrayList<Integer>(Arrays.asList(3, 34, 36, 67)));
		adj.put(36, new ArrayList<Integer>(Arrays.asList(4, 35, 37, 68)));
		adj.put(37, new ArrayList<Integer>(Arrays.asList(5, 36, 38, 69)));
		adj.put(38, new ArrayList<Integer>(Arrays.asList(6, 37, 39, 70)));
		adj.put(39, new ArrayList<Integer>(Arrays.asList(7, 38, 40, 71)));
		adj.put(40, new ArrayList<Integer>(Arrays.asList(8, 39, 41, 72)));
		adj.put(41, new ArrayList<Integer>(Arrays.asList(9, 40, 42, 73)));
		adj.put(42, new ArrayList<Integer>(Arrays.asList(10, 41, 43, 74)));
		adj.put(43, new ArrayList<Integer>(Arrays.asList(11, 42, 44, 75)));
		adj.put(44, new ArrayList<Integer>(Arrays.asList(12, 43, 45, 76)));
		adj.put(45, new ArrayList<Integer>(Arrays.asList(13, 44, 46, 77)));
		adj.put(46, new ArrayList<Integer>(Arrays.asList(14, 45, 47, 78)));
		adj.put(47, new ArrayList<Integer>(Arrays.asList(15, 46, 48, 79)));
		adj.put(48, new ArrayList<Integer>(Arrays.asList(16, 47, 49, 80)));
		adj.put(49, new ArrayList<Integer>(Arrays.asList(17, 48, 50, 81)));
		adj.put(50, new ArrayList<Integer>(Arrays.asList(18, 49, 51, 82)));
		adj.put(51, new ArrayList<Integer>(Arrays.asList(19, 50, 52, 83)));
		adj.put(52, new ArrayList<Integer>(Arrays.asList(20, 51, 53, 84)));
		adj.put(53, new ArrayList<Integer>(Arrays.asList(21, 52, 54, 85)));
		adj.put(54, new ArrayList<Integer>(Arrays.asList(22, 53, 55, 86)));
		adj.put(55, new ArrayList<Integer>(Arrays.asList(23, 54, 56, 87)));
		adj.put(56, new ArrayList<Integer>(Arrays.asList(24, 55, 57, 88)));
		adj.put(57, new ArrayList<Integer>(Arrays.asList(25, 56, 58, 89)));
		adj.put(58, new ArrayList<Integer>(Arrays.asList(26, 57, 59, 90)));
		adj.put(59, new ArrayList<Integer>(Arrays.asList(27, 58, 60, 91)));
		adj.put(60, new ArrayList<Integer>(Arrays.asList(28, 59, 61, 92)));
		adj.put(61, new ArrayList<Integer>(Arrays.asList(29, 60, 62, 93)));
		adj.put(62, new ArrayList<Integer>(Arrays.asList(30, 61, 63, 94)));
		adj.put(63, new ArrayList<Integer>(Arrays.asList(31, 62, 95)));

		/* ROW 2 */
		adj.put(64, new ArrayList<Integer>(Arrays.asList(32, 65, 96)));
		adj.put(65, new ArrayList<Integer>(Arrays.asList(33, 64, 66, 97)));
		adj.put(66, new ArrayList<Integer>(Arrays.asList(34, 65, 67, 98)));
		adj.put(67, new ArrayList<Integer>(Arrays.asList(35, 66, 68, 99)));
		adj.put(68, new ArrayList<Integer>(Arrays.asList(36, 67, 69, 100)));
		adj.put(69, new ArrayList<Integer>(Arrays.asList(37, 68, 70, 101)));
		adj.put(70, new ArrayList<Integer>(Arrays.asList(38, 69, 71, 102)));
		adj.put(71, new ArrayList<Integer>(Arrays.asList(39, 70, 72, 103)));
		adj.put(72, new ArrayList<Integer>(Arrays.asList(40, 71, 73, 104)));
		adj.put(73, new ArrayList<Integer>(Arrays.asList(41, 72, 74, 105)));
		adj.put(74, new ArrayList<Integer>(Arrays.asList(42, 73, 75, 106)));
		adj.put(75, new ArrayList<Integer>(Arrays.asList(43, 74, 76, 107)));
		adj.put(76, new ArrayList<Integer>(Arrays.asList(44, 75, 77, 108)));
		adj.put(77, new ArrayList<Integer>(Arrays.asList(45, 76, 78, 109)));
		adj.put(78, new ArrayList<Integer>(Arrays.asList(46, 77, 79, 110)));
		adj.put(79, new ArrayList<Integer>(Arrays.asList(47, 78, 80, 111)));
		adj.put(80, new ArrayList<Integer>(Arrays.asList(48, 79, 81, 112)));
		adj.put(81, new ArrayList<Integer>(Arrays.asList(49, 80, 82, 113)));
		adj.put(82, new ArrayList<Integer>(Arrays.asList(50, 81, 83, 114)));
		adj.put(83, new ArrayList<Integer>(Arrays.asList(51, 82, 84, 115)));
		adj.put(84, new ArrayList<Integer>(Arrays.asList(52, 83, 85, 116)));
		adj.put(85, new ArrayList<Integer>(Arrays.asList(53, 84, 86, 117)));
		adj.put(86, new ArrayList<Integer>(Arrays.asList(54, 85, 87, 118)));
		adj.put(87, new ArrayList<Integer>(Arrays.asList(55, 86, 88, 119)));
		adj.put(88, new ArrayList<Integer>(Arrays.asList(56, 87, 89, 120)));
		adj.put(89, new ArrayList<Integer>(Arrays.asList(57, 88, 90, 121)));
		adj.put(90, new ArrayList<Integer>(Arrays.asList(58, 89, 91, 123)));
		adj.put(91, new ArrayList<Integer>(Arrays.asList(59, 90, 92, 124)));
		adj.put(92, new ArrayList<Integer>(Arrays.asList(60, 91, 93, 125)));
		adj.put(93, new ArrayList<Integer>(Arrays.asList(61, 92, 94, 126)));
		adj.put(94, new ArrayList<Integer>(Arrays.asList(62, 93, 95, 127)));
		adj.put(95, new ArrayList<Integer>(Arrays.asList(63, 94, 128)));

		/* ROW 3 */
		adj.put(96, new ArrayList<Integer>(Arrays.asList(64, 97, 128)));
		adj.put(97, new ArrayList<Integer>(Arrays.asList(65, 96, 98, 129)));
		adj.put(98, new ArrayList<Integer>(Arrays.asList(66, 97, 99, 130)));
		adj.put(99, new ArrayList<Integer>(Arrays.asList(67, 98, 100, 131)));
		adj.put(100, new ArrayList<Integer>(Arrays.asList(68, 99, 101, 132)));
		adj.put(101, new ArrayList<Integer>(Arrays.asList(69, 100, 101, 133)));
		adj.put(102, new ArrayList<Integer>(Arrays.asList(70, 101, 103, 134)));
		adj.put(103, new ArrayList<Integer>(Arrays.asList(71, 102, 104, 135)));
		adj.put(104, new ArrayList<Integer>(Arrays.asList(72, 103, 105, 136)));
		adj.put(105, new ArrayList<Integer>(Arrays.asList(73, 104, 106, 137)));
		adj.put(106, new ArrayList<Integer>(Arrays.asList(74, 105, 107, 138)));
		adj.put(107, new ArrayList<Integer>(Arrays.asList(75, 106, 108, 139)));
		adj.put(108, new ArrayList<Integer>(Arrays.asList(76, 107, 109, 140)));
		adj.put(109, new ArrayList<Integer>(Arrays.asList(77, 108, 110, 141)));
		adj.put(110, new ArrayList<Integer>(Arrays.asList(78, 109, 111, 142)));
		adj.put(111, new ArrayList<Integer>(Arrays.asList(79, 110, 112, 143)));
		adj.put(112, new ArrayList<Integer>(Arrays.asList(80, 111, 113, 144)));
		adj.put(113, new ArrayList<Integer>(Arrays.asList(81, 112, 114, 145)));
		adj.put(114, new ArrayList<Integer>(Arrays.asList(82, 113, 115, 146)));
		adj.put(115, new ArrayList<Integer>(Arrays.asList(83, 114, 116, 147)));
		adj.put(116, new ArrayList<Integer>(Arrays.asList(84, 115, 117, 148)));
		adj.put(117, new ArrayList<Integer>(Arrays.asList(85, 116, 118, 149)));
		adj.put(118, new ArrayList<Integer>(Arrays.asList(86, 117, 119, 150)));
		adj.put(119, new ArrayList<Integer>(Arrays.asList(87, 118, 120, 151)));
		adj.put(120, new ArrayList<Integer>(Arrays.asList(88, 119, 121, 152)));
		adj.put(121, new ArrayList<Integer>(Arrays.asList(89, 120, 122, 153)));
		adj.put(122, new ArrayList<Integer>(Arrays.asList(90, 121, 123, 154)));
		adj.put(123, new ArrayList<Integer>(Arrays.asList(91, 122, 124, 155)));
		adj.put(124, new ArrayList<Integer>(Arrays.asList(92, 123, 125, 156)));
		adj.put(125, new ArrayList<Integer>(Arrays.asList(93, 124, 126, 157)));
		adj.put(126, new ArrayList<Integer>(Arrays.asList(94, 125, 127, 158)));
		adj.put(127, new ArrayList<Integer>(Arrays.asList(95, 126, 159)));

		/* ROW 4 */
		adj.put(128, new ArrayList<Integer>(Arrays.asList(96, 129, 160)));
		adj.put(129, new ArrayList<Integer>(Arrays.asList(97, 128, 130, 161)));
		adj.put(130, new ArrayList<Integer>(Arrays.asList(98, 129, 131, 162)));
		adj.put(131, new ArrayList<Integer>(Arrays.asList(99, 130, 132, 163)));
		adj.put(132, new ArrayList<Integer>(Arrays.asList(100, 131, 133, 164)));
		adj.put(133, new ArrayList<Integer>(Arrays.asList(101, 132, 134, 165)));
		adj.put(134, new ArrayList<Integer>(Arrays.asList(102, 133, 135, 166)));
		adj.put(135, new ArrayList<Integer>(Arrays.asList(103, 134, 136, 167)));
		adj.put(136, new ArrayList<Integer>(Arrays.asList(104, 135, 137, 168)));
		adj.put(137, new ArrayList<Integer>(Arrays.asList(105, 136, 138, 169)));
		adj.put(138, new ArrayList<Integer>(Arrays.asList(106, 137, 139, 170)));
		adj.put(139, new ArrayList<Integer>(Arrays.asList(107, 138, 140, 171)));
		adj.put(140, new ArrayList<Integer>(Arrays.asList(108, 139, 141, 172)));
		adj.put(141, new ArrayList<Integer>(Arrays.asList(109, 140, 142, 173)));
		adj.put(142, new ArrayList<Integer>(Arrays.asList(110, 141, 143, 174)));
		adj.put(143, new ArrayList<Integer>(Arrays.asList(111, 142, 144, 175)));
		adj.put(144, new ArrayList<Integer>(Arrays.asList(112, 143, 145, 176)));
		adj.put(145, new ArrayList<Integer>(Arrays.asList(113, 144, 146, 177)));
		adj.put(146, new ArrayList<Integer>(Arrays.asList(114, 145, 147, 178)));
		adj.put(147, new ArrayList<Integer>(Arrays.asList(115, 146, 148, 179)));
		adj.put(148, new ArrayList<Integer>(Arrays.asList(116, 147, 149, 180)));
		adj.put(149, new ArrayList<Integer>(Arrays.asList(117, 148, 150, 181)));
		adj.put(150, new ArrayList<Integer>(Arrays.asList(118, 149, 151, 182)));
		adj.put(151, new ArrayList<Integer>(Arrays.asList(119, 150, 152, 183)));
		adj.put(152, new ArrayList<Integer>(Arrays.asList(120, 151, 153, 184)));
		adj.put(153, new ArrayList<Integer>(Arrays.asList(121, 152, 154, 185)));
		adj.put(154, new ArrayList<Integer>(Arrays.asList(122, 153, 155, 186)));
		adj.put(155, new ArrayList<Integer>(Arrays.asList(123, 154, 156, 187)));
		adj.put(156, new ArrayList<Integer>(Arrays.asList(124, 155, 157, 188)));
		adj.put(157, new ArrayList<Integer>(Arrays.asList(125, 156, 158, 189)));
		adj.put(158, new ArrayList<Integer>(Arrays.asList(126, 157, 159, 190)));
		adj.put(159, new ArrayList<Integer>(Arrays.asList(127, 158, 191)));

		/* ROW 5 */
		adj.put(160, new ArrayList<Integer>(Arrays.asList(128, 161, 192)));
		adj.put(161, new ArrayList<Integer>(Arrays.asList(129, 160, 162, 193)));
		adj.put(162, new ArrayList<Integer>(Arrays.asList(130, 161, 163, 194)));
		adj.put(163, new ArrayList<Integer>(Arrays.asList(131, 162, 164, 195)));
		adj.put(164, new ArrayList<Integer>(Arrays.asList(132, 163, 165, 196)));
		adj.put(165, new ArrayList<Integer>(Arrays.asList(133, 164, 166, 197)));
		adj.put(166, new ArrayList<Integer>(Arrays.asList(134, 165, 167, 198)));
		adj.put(167, new ArrayList<Integer>(Arrays.asList(135, 166, 168, 199)));
		adj.put(168, new ArrayList<Integer>(Arrays.asList(136, 167, 169, 200)));
		adj.put(169, new ArrayList<Integer>(Arrays.asList(137, 168, 170, 201)));
		adj.put(170, new ArrayList<Integer>(Arrays.asList(138, 169, 171, 202)));
		adj.put(171, new ArrayList<Integer>(Arrays.asList(139, 170, 172, 203)));
		adj.put(172, new ArrayList<Integer>(Arrays.asList(140, 171, 173, 204)));
		adj.put(173, new ArrayList<Integer>(Arrays.asList(141, 172, 174, 205)));
		adj.put(174, new ArrayList<Integer>(Arrays.asList(142, 173, 175, 206)));
		adj.put(175, new ArrayList<Integer>(Arrays.asList(143, 174, 176, 207)));
		adj.put(176, new ArrayList<Integer>(Arrays.asList(144, 175, 177, 208)));
		adj.put(177, new ArrayList<Integer>(Arrays.asList(145, 176, 178, 209)));
		adj.put(178, new ArrayList<Integer>(Arrays.asList(146, 177, 179, 210)));
		adj.put(179, new ArrayList<Integer>(Arrays.asList(147, 178, 180, 211)));
		adj.put(180, new ArrayList<Integer>(Arrays.asList(148, 179, 181, 212)));
		adj.put(181, new ArrayList<Integer>(Arrays.asList(149, 180, 182, 213)));
		adj.put(182, new ArrayList<Integer>(Arrays.asList(150, 181, 183, 214)));
		adj.put(183, new ArrayList<Integer>(Arrays.asList(151, 182, 184, 215)));
		adj.put(184, new ArrayList<Integer>(Arrays.asList(152, 183, 185, 216)));
		adj.put(185, new ArrayList<Integer>(Arrays.asList(153, 184, 186, 217)));
		adj.put(186, new ArrayList<Integer>(Arrays.asList(154, 185, 187, 218)));
		adj.put(187, new ArrayList<Integer>(Arrays.asList(155, 186, 188, 219)));
		adj.put(188, new ArrayList<Integer>(Arrays.asList(156, 187, 189, 220)));
		adj.put(189, new ArrayList<Integer>(Arrays.asList(157, 188, 190, 221)));
		adj.put(190, new ArrayList<Integer>(Arrays.asList(158, 189, 191, 222)));
		adj.put(191, new ArrayList<Integer>(Arrays.asList(159, 190, 223)));

		/* ROW 6 */
		adj.put(192, new ArrayList<Integer>(Arrays.asList(160, 193, 224)));
		adj.put(193, new ArrayList<Integer>(Arrays.asList(161, 192, 194, 225)));
		adj.put(194, new ArrayList<Integer>(Arrays.asList(162, 193, 195, 226)));
		adj.put(195, new ArrayList<Integer>(Arrays.asList(163, 194, 196, 227)));
		adj.put(196, new ArrayList<Integer>(Arrays.asList(164, 195, 197, 228)));
		adj.put(197, new ArrayList<Integer>(Arrays.asList(165, 196, 198, 229)));
		adj.put(198, new ArrayList<Integer>(Arrays.asList(166, 197, 199, 230)));
		adj.put(199, new ArrayList<Integer>(Arrays.asList(167, 198, 200, 231)));
		adj.put(200, new ArrayList<Integer>(Arrays.asList(168, 199, 201, 232)));
		adj.put(201, new ArrayList<Integer>(Arrays.asList(169, 200, 202, 233)));
		adj.put(202, new ArrayList<Integer>(Arrays.asList(170, 201, 203, 234)));
		adj.put(203, new ArrayList<Integer>(Arrays.asList(171, 202, 204, 235)));
		adj.put(204, new ArrayList<Integer>(Arrays.asList(172, 203, 205, 236)));
		adj.put(205, new ArrayList<Integer>(Arrays.asList(173, 204, 206, 237)));
		adj.put(206, new ArrayList<Integer>(Arrays.asList(174, 205, 207, 238)));
		adj.put(207, new ArrayList<Integer>(Arrays.asList(175, 206, 208, 239)));
		adj.put(208, new ArrayList<Integer>(Arrays.asList(176, 207, 209, 240)));
		adj.put(209, new ArrayList<Integer>(Arrays.asList(177, 208, 210, 241)));
		adj.put(210, new ArrayList<Integer>(Arrays.asList(178, 209, 211, 242)));
		adj.put(211, new ArrayList<Integer>(Arrays.asList(179, 210, 212, 243)));
		adj.put(212, new ArrayList<Integer>(Arrays.asList(180, 211, 213, 244)));
		adj.put(213, new ArrayList<Integer>(Arrays.asList(181, 212, 214, 245)));
		adj.put(214, new ArrayList<Integer>(Arrays.asList(182, 213, 215, 246)));
		adj.put(215, new ArrayList<Integer>(Arrays.asList(183, 214, 216, 247)));
		adj.put(216, new ArrayList<Integer>(Arrays.asList(184, 215, 217, 248)));
		adj.put(217, new ArrayList<Integer>(Arrays.asList(185, 216, 218, 249)));
		adj.put(218, new ArrayList<Integer>(Arrays.asList(186, 217, 219, 250)));
		adj.put(219, new ArrayList<Integer>(Arrays.asList(187, 218, 220, 251)));
		adj.put(220, new ArrayList<Integer>(Arrays.asList(188, 219, 221, 252)));
		adj.put(221, new ArrayList<Integer>(Arrays.asList(189, 220, 222, 253)));
		adj.put(222, new ArrayList<Integer>(Arrays.asList(190, 221, 223, 254)));
		adj.put(223, new ArrayList<Integer>(Arrays.asList(191, 222, 255)));

		/* ROW 7 */
		adj.put(224, new ArrayList<Integer>(Arrays.asList(160, 225, 256)));
		adj.put(225, new ArrayList<Integer>(Arrays.asList(161, 224, 226, 257)));
		adj.put(226, new ArrayList<Integer>(Arrays.asList(162, 225, 227, 258)));
		adj.put(227, new ArrayList<Integer>(Arrays.asList(163, 226, 228, 259)));
		adj.put(228, new ArrayList<Integer>(Arrays.asList(164, 227, 229, 260)));
		adj.put(229, new ArrayList<Integer>(Arrays.asList(165, 228, 230, 261)));
		adj.put(230, new ArrayList<Integer>(Arrays.asList(166, 229, 231, 262)));
		adj.put(231, new ArrayList<Integer>(Arrays.asList(167, 230, 232, 263)));
		adj.put(232, new ArrayList<Integer>(Arrays.asList(168, 231, 233, 264)));
		adj.put(233, new ArrayList<Integer>(Arrays.asList(169, 232, 234, 265)));
		adj.put(234, new ArrayList<Integer>(Arrays.asList(170, 233, 235, 266)));
		adj.put(235, new ArrayList<Integer>(Arrays.asList(171, 234, 236, 267)));
		adj.put(236, new ArrayList<Integer>(Arrays.asList(172, 235, 237, 268)));
		adj.put(237, new ArrayList<Integer>(Arrays.asList(173, 236, 238, 269)));
		adj.put(238, new ArrayList<Integer>(Arrays.asList(174, 237, 239, 270)));
		adj.put(239, new ArrayList<Integer>(Arrays.asList(175, 238, 240, 271)));
		adj.put(240, new ArrayList<Integer>(Arrays.asList(176, 239, 241, 272)));
		adj.put(241, new ArrayList<Integer>(Arrays.asList(177, 240, 242, 273)));
		adj.put(242, new ArrayList<Integer>(Arrays.asList(178, 241, 243, 274)));
		adj.put(243, new ArrayList<Integer>(Arrays.asList(179, 242, 244, 275)));
		adj.put(244, new ArrayList<Integer>(Arrays.asList(180, 243, 245, 276)));
		adj.put(245, new ArrayList<Integer>(Arrays.asList(181, 244, 246, 277)));
		adj.put(246, new ArrayList<Integer>(Arrays.asList(182, 245, 247, 278)));
		adj.put(247, new ArrayList<Integer>(Arrays.asList(183, 246, 248, 279)));
		adj.put(248, new ArrayList<Integer>(Arrays.asList(184, 247, 249, 280)));
		adj.put(249, new ArrayList<Integer>(Arrays.asList(185, 248, 250, 281)));
		adj.put(250, new ArrayList<Integer>(Arrays.asList(186, 249, 251, 282)));
		adj.put(251, new ArrayList<Integer>(Arrays.asList(187, 250, 252, 283)));
		adj.put(252, new ArrayList<Integer>(Arrays.asList(188, 251, 253, 284)));
		adj.put(253, new ArrayList<Integer>(Arrays.asList(189, 252, 254, 285)));
		adj.put(254, new ArrayList<Integer>(Arrays.asList(190, 253, 255, 286)));
		adj.put(255, new ArrayList<Integer>(Arrays.asList(191, 254, 287)));

		/* ROW 8 */
		adj.put(256, new ArrayList<Integer>(Arrays.asList(224, 257, 288)));
		adj.put(257, new ArrayList<Integer>(Arrays.asList(225, 256, 258, 289)));
		adj.put(258, new ArrayList<Integer>(Arrays.asList(226, 257, 259, 290)));
		adj.put(259, new ArrayList<Integer>(Arrays.asList(227, 258, 260, 291)));
		adj.put(260, new ArrayList<Integer>(Arrays.asList(228, 259, 261, 292)));
		adj.put(261, new ArrayList<Integer>(Arrays.asList(229, 260, 262, 293)));
		adj.put(262, new ArrayList<Integer>(Arrays.asList(230, 261, 263, 294)));
		adj.put(263, new ArrayList<Integer>(Arrays.asList(231, 262, 264, 295)));
		adj.put(264, new ArrayList<Integer>(Arrays.asList(232, 263, 265, 296)));
		adj.put(265, new ArrayList<Integer>(Arrays.asList(233, 264, 266, 297)));
		adj.put(266, new ArrayList<Integer>(Arrays.asList(234, 265, 267, 298)));
		adj.put(267, new ArrayList<Integer>(Arrays.asList(235, 266, 268, 299)));
		adj.put(268, new ArrayList<Integer>(Arrays.asList(236, 267, 269, 300)));
		adj.put(269, new ArrayList<Integer>(Arrays.asList(237, 268, 270, 301)));
		adj.put(270, new ArrayList<Integer>(Arrays.asList(238, 269, 271, 302)));
		adj.put(271, new ArrayList<Integer>(Arrays.asList(239, 270, 272, 303)));
		adj.put(272, new ArrayList<Integer>(Arrays.asList(240, 271, 273, 304)));
		adj.put(273, new ArrayList<Integer>(Arrays.asList(241, 272, 274, 305)));
		adj.put(274, new ArrayList<Integer>(Arrays.asList(242, 273, 275, 306)));
		adj.put(275, new ArrayList<Integer>(Arrays.asList(243, 274, 276, 307)));
		adj.put(276, new ArrayList<Integer>(Arrays.asList(244, 275, 277, 308)));
		adj.put(277, new ArrayList<Integer>(Arrays.asList(245, 276, 278, 309)));
		adj.put(278, new ArrayList<Integer>(Arrays.asList(246, 277, 279, 310)));
		adj.put(279, new ArrayList<Integer>(Arrays.asList(247, 278, 280, 311)));
		adj.put(280, new ArrayList<Integer>(Arrays.asList(248, 279, 281, 312)));
		adj.put(281, new ArrayList<Integer>(Arrays.asList(249, 280, 282, 313)));
		adj.put(282, new ArrayList<Integer>(Arrays.asList(250, 281, 283, 314)));
		adj.put(283, new ArrayList<Integer>(Arrays.asList(251, 282, 284, 315)));
		adj.put(284, new ArrayList<Integer>(Arrays.asList(252, 283, 285, 316)));
		adj.put(285, new ArrayList<Integer>(Arrays.asList(253, 284, 286, 317)));
		adj.put(286, new ArrayList<Integer>(Arrays.asList(254, 285, 287, 318)));
		adj.put(287, new ArrayList<Integer>(Arrays.asList(255, 286, 319)));

		/* ROW 9 */
		adj.put(288, new ArrayList<Integer>(Arrays.asList(256, 289, 320)));
		adj.put(289, new ArrayList<Integer>(Arrays.asList(257, 288, 290, 321)));
		adj.put(290, new ArrayList<Integer>(Arrays.asList(258, 289, 291, 322)));
		adj.put(291, new ArrayList<Integer>(Arrays.asList(259, 290, 292, 323)));
		adj.put(292, new ArrayList<Integer>(Arrays.asList(260, 291, 293, 324)));
		adj.put(293, new ArrayList<Integer>(Arrays.asList(261, 292, 294, 325)));
		adj.put(294, new ArrayList<Integer>(Arrays.asList(262, 293, 295, 326)));
		adj.put(295, new ArrayList<Integer>(Arrays.asList(263, 294, 296, 327)));
		adj.put(296, new ArrayList<Integer>(Arrays.asList(264, 295, 297, 328)));
		adj.put(297, new ArrayList<Integer>(Arrays.asList(265, 296, 298, 329)));
		adj.put(298, new ArrayList<Integer>(Arrays.asList(266, 297, 299, 330)));
		adj.put(299, new ArrayList<Integer>(Arrays.asList(267, 298, 300, 331)));
		adj.put(300, new ArrayList<Integer>(Arrays.asList(268, 299, 301, 332)));
		adj.put(301, new ArrayList<Integer>(Arrays.asList(269, 300, 302, 333)));
		adj.put(302, new ArrayList<Integer>(Arrays.asList(270, 301, 303, 334)));
		adj.put(303, new ArrayList<Integer>(Arrays.asList(271, 302, 304, 335)));
		adj.put(304, new ArrayList<Integer>(Arrays.asList(272, 303, 305, 336)));
		adj.put(305, new ArrayList<Integer>(Arrays.asList(273, 304, 306, 337)));
		adj.put(306, new ArrayList<Integer>(Arrays.asList(274, 305, 306, 338)));
		adj.put(307, new ArrayList<Integer>(Arrays.asList(275, 306, 308, 339)));
		adj.put(308, new ArrayList<Integer>(Arrays.asList(276, 307, 309, 340)));
		adj.put(309, new ArrayList<Integer>(Arrays.asList(277, 308, 310, 341)));
		adj.put(310, new ArrayList<Integer>(Arrays.asList(278, 309, 311, 342)));
		adj.put(311, new ArrayList<Integer>(Arrays.asList(279, 310, 312, 343)));
		adj.put(312, new ArrayList<Integer>(Arrays.asList(280, 311, 313, 344)));
		adj.put(313, new ArrayList<Integer>(Arrays.asList(281, 312, 314, 345)));
		adj.put(314, new ArrayList<Integer>(Arrays.asList(282, 313, 315, 346)));
		adj.put(315, new ArrayList<Integer>(Arrays.asList(283, 314, 316, 347)));
		adj.put(316, new ArrayList<Integer>(Arrays.asList(284, 315, 317, 348)));
		adj.put(317, new ArrayList<Integer>(Arrays.asList(285, 316, 318, 349)));
		adj.put(318, new ArrayList<Integer>(Arrays.asList(286, 317, 319, 350)));
		adj.put(319, new ArrayList<Integer>(Arrays.asList(287, 318, 351)));

		/* ROW 10 */
		adj.put(320, new ArrayList<Integer>(Arrays.asList(288, 321, 352)));
		adj.put(321, new ArrayList<Integer>(Arrays.asList(289, 320, 322, 353)));
		adj.put(322, new ArrayList<Integer>(Arrays.asList(290, 321, 323, 354)));
		adj.put(323, new ArrayList<Integer>(Arrays.asList(291, 322, 324, 355)));
		adj.put(324, new ArrayList<Integer>(Arrays.asList(292, 323, 325, 356)));
		adj.put(325, new ArrayList<Integer>(Arrays.asList(293, 324, 326, 357)));
		adj.put(326, new ArrayList<Integer>(Arrays.asList(294, 325, 327, 358)));
		adj.put(327, new ArrayList<Integer>(Arrays.asList(295, 326, 328, 359)));
		adj.put(328, new ArrayList<Integer>(Arrays.asList(296, 327, 329, 360)));
		adj.put(329, new ArrayList<Integer>(Arrays.asList(297, 328, 330, 361)));
		adj.put(330, new ArrayList<Integer>(Arrays.asList(298, 329, 331, 362)));
		adj.put(331, new ArrayList<Integer>(Arrays.asList(299, 330, 332, 363)));
		adj.put(332, new ArrayList<Integer>(Arrays.asList(300, 331, 333, 364)));
		adj.put(333, new ArrayList<Integer>(Arrays.asList(301, 332, 334, 365)));
		adj.put(334, new ArrayList<Integer>(Arrays.asList(302, 333, 335, 366)));
		adj.put(335, new ArrayList<Integer>(Arrays.asList(303, 334, 336, 367)));
		adj.put(336, new ArrayList<Integer>(Arrays.asList(304, 335, 337, 368)));
		adj.put(337, new ArrayList<Integer>(Arrays.asList(305, 336, 338, 369)));
		adj.put(338, new ArrayList<Integer>(Arrays.asList(306, 337, 339, 370)));
		adj.put(339, new ArrayList<Integer>(Arrays.asList(307, 338, 340, 371)));
		adj.put(340, new ArrayList<Integer>(Arrays.asList(308, 339, 341, 372)));
		adj.put(341, new ArrayList<Integer>(Arrays.asList(309, 340, 342, 373)));
		adj.put(342, new ArrayList<Integer>(Arrays.asList(310, 341, 343, 374)));
		adj.put(343, new ArrayList<Integer>(Arrays.asList(311, 342, 344, 375)));
		adj.put(344, new ArrayList<Integer>(Arrays.asList(312, 343, 345, 376)));
		adj.put(345, new ArrayList<Integer>(Arrays.asList(313, 344, 346, 377)));
		adj.put(346, new ArrayList<Integer>(Arrays.asList(314, 345, 347, 378)));
		adj.put(347, new ArrayList<Integer>(Arrays.asList(315, 346, 348, 379)));
		adj.put(348, new ArrayList<Integer>(Arrays.asList(316, 347, 349, 380)));
		adj.put(349, new ArrayList<Integer>(Arrays.asList(317, 348, 350, 381)));
		adj.put(350, new ArrayList<Integer>(Arrays.asList(318, 349, 351, 382)));
		adj.put(351, new ArrayList<Integer>(Arrays.asList(319, 350, 383)));

		/* ROW 11 */
		adj.put(352, new ArrayList<Integer>(Arrays.asList(320, 353, 384)));
		adj.put(353, new ArrayList<Integer>(Arrays.asList(321, 352, 354, 385)));
		adj.put(354, new ArrayList<Integer>(Arrays.asList(322, 353, 355, 386)));
		adj.put(355, new ArrayList<Integer>(Arrays.asList(323, 354, 356, 387)));
		adj.put(356, new ArrayList<Integer>(Arrays.asList(324, 355, 357, 388)));
		adj.put(357, new ArrayList<Integer>(Arrays.asList(325, 356, 358, 389)));
		adj.put(358, new ArrayList<Integer>(Arrays.asList(326, 357, 359, 390)));
		adj.put(359, new ArrayList<Integer>(Arrays.asList(327, 358, 360, 391)));
		adj.put(360, new ArrayList<Integer>(Arrays.asList(328, 359, 361, 392)));
		adj.put(361, new ArrayList<Integer>(Arrays.asList(329, 360, 362, 393)));
		adj.put(362, new ArrayList<Integer>(Arrays.asList(330, 361, 363, 394)));
		adj.put(363, new ArrayList<Integer>(Arrays.asList(331, 362, 364, 395)));
		adj.put(364, new ArrayList<Integer>(Arrays.asList(332, 363, 365, 396)));
		adj.put(365, new ArrayList<Integer>(Arrays.asList(333, 364, 366, 397)));
		adj.put(366, new ArrayList<Integer>(Arrays.asList(334, 365, 367, 398)));
		adj.put(367, new ArrayList<Integer>(Arrays.asList(335, 366, 368, 399)));
		adj.put(368, new ArrayList<Integer>(Arrays.asList(336, 367, 369, 400)));
		adj.put(369, new ArrayList<Integer>(Arrays.asList(337, 368, 370, 401)));
		adj.put(370, new ArrayList<Integer>(Arrays.asList(338, 369, 371, 402)));
		adj.put(371, new ArrayList<Integer>(Arrays.asList(339, 370, 372, 403)));
		adj.put(372, new ArrayList<Integer>(Arrays.asList(340, 371, 373, 404)));
		adj.put(373, new ArrayList<Integer>(Arrays.asList(341, 372, 374, 405)));
		adj.put(374, new ArrayList<Integer>(Arrays.asList(342, 373, 375, 406)));
		adj.put(375, new ArrayList<Integer>(Arrays.asList(343, 374, 376, 407)));
		adj.put(376, new ArrayList<Integer>(Arrays.asList(344, 375, 377, 408)));
		adj.put(377, new ArrayList<Integer>(Arrays.asList(345, 376, 378, 409)));
		adj.put(378, new ArrayList<Integer>(Arrays.asList(346, 377, 379, 410)));
		adj.put(379, new ArrayList<Integer>(Arrays.asList(347, 378, 380, 411)));
		adj.put(380, new ArrayList<Integer>(Arrays.asList(348, 379, 381, 412)));
		adj.put(381, new ArrayList<Integer>(Arrays.asList(349, 380, 382, 413)));
		adj.put(382, new ArrayList<Integer>(Arrays.asList(350, 381, 383, 414)));
		adj.put(383, new ArrayList<Integer>(Arrays.asList(351, 382, 415)));

		/* ROW 12 */
		adj.put(384, new ArrayList<Integer>(Arrays.asList(352, 385, 416)));
		adj.put(385, new ArrayList<Integer>(Arrays.asList(353, 384, 386, 417)));
		adj.put(386, new ArrayList<Integer>(Arrays.asList(354, 3)));
		adj.put(387, new ArrayList<Integer>(Arrays.asList(355, 3)));
		adj.put(388, new ArrayList<Integer>(Arrays.asList(356, 3)));
		adj.put(389, new ArrayList<Integer>(Arrays.asList(357, 3)));
		adj.put(390, new ArrayList<Integer>(Arrays.asList(358, 3)));
		adj.put(391, new ArrayList<Integer>(Arrays.asList(359, 3)));
		adj.put(392, new ArrayList<Integer>(Arrays.asList(360, 3)));
		adj.put(393, new ArrayList<Integer>(Arrays.asList(361, 3)));
		adj.put(394, new ArrayList<Integer>(Arrays.asList(382, 3)));
		adj.put(395, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(396, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(397, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(398, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(399, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(400, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(401, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(402, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(403, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(404, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(405, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(406, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(407, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(408, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(409, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(410, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(411, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(412, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(413, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(414, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(415, new ArrayList<Integer>(Arrays.asList(1, 3)));

		/* ROW 13 */
		adj.put(416, new ArrayList<Integer>(Arrays.asList(384, 417, 448)));
		adj.put(417, new ArrayList<Integer>(Arrays.asList(385, 416, 418, 449)));
		adj.put(418, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(419, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(420, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(421, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(422, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(423, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(424, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(425, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(426, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(427, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(428, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(429, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(430, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(431, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(432, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(433, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(434, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(435, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(436, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(437, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(438, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(439, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(440, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(441, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(442, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(443, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(444, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(445, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(446, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(447, new ArrayList<Integer>(Arrays.asList(1, 3)));

		/* ROW 14 */
		adj.put(448, new ArrayList<Integer>(Arrays.asList(416, 449, 480)));
		adj.put(449, new ArrayList<Integer>(Arrays.asList(417, 448, 450, 481)));
		adj.put(450, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(451, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(452, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(453, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(454, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(455, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(456, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(457, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(458, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(459, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(460, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(461, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(462, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(463, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(464, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(465, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(466, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(467, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(468, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(469, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(470, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(471, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(472, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(473, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(474, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(475, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(476, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(477, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(478, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(479, new ArrayList<Integer>(Arrays.asList(1, 3)));

		/* ROW 15 */
		adj.put(480, new ArrayList<Integer>(Arrays.asList(448, 481, 512)));
		adj.put(481, new ArrayList<Integer>(Arrays.asList(449, 480, 482, 513)));
		adj.put(482, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(483, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(484, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(485, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(486, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(487, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(488, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(489, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(490, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(491, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(492, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(493, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(494, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(495, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(496, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(497, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(498, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(499, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(500, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(501, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(502, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(503, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(504, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(505, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(506, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(507, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(508, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(509, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(510, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(511, new ArrayList<Integer>(Arrays.asList(1, 3)));

		/* ROW 16 */
		adj.put(512, new ArrayList<Integer>(Arrays.asList(480, 513, 544)));
		adj.put(513, new ArrayList<Integer>(Arrays.asList(481, 512, 514, 545)));
		adj.put(514, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(515, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(516, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(517, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(518, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(519, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(520, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(521, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(522, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(523, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(524, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(525, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(526, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(527, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(528, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(529, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(530, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(531, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(532, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(533, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(534, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(535, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(536, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(537, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(538, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(539, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(540, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(541, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(542, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(543, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(544, new ArrayList<Integer>(Arrays.asList(1, 3)));

		/* ROW 17 */
		adj.put(545, new ArrayList<Integer>(Arrays.asList(512, 546)));
		adj.put(546, new ArrayList<Integer>(Arrays.asList(513, 545, 547)));
		adj.put(547, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(548, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(549, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(550, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(551, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(552, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(553, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(554, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(555, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(556, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(557, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(558, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(559, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(560, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(561, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(562, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(563, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(564, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(565, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(566, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(567, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(568, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(569, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(570, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(571, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(572, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(573, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(574, new ArrayList<Integer>(Arrays.asList(1, 3)));
		adj.put(575, new ArrayList<Integer>(Arrays.asList(1, 3)));

		Path path = new Path(graph, adj, start, end);
		System.out.println("PATH: " + path.getPath().toString());
		System.out.println("VALUE: " + path.getValue());

	}
}
