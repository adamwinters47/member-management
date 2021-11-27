
## Dock Info
insert into bc.dock (dock.id, dock.dock_name) values (1, 'AN'), (2, 'AS'), (3, 'BN'), (4, 'BS'), (5, 'CN');


## DOCK AN
insert into bc.slip (slip.id, slip.length, slip.width, slip.slip_type, slip.dock_id) values
(1, 25, 11.6, 'wet', 1), (2, 25, 11.3, 'wet', 1), (3, 25, 10.2, 'wet', 1), (4, 25, 11.9, 'wet', 1),
(5, 25, 11.8, 'wet', 1), (6, 25, 10.9, 'wet', 1), (7,25, 11.7, 'wet', 1), (8, 25, 10.9, 'wet', 1),
(9, 25, 11.8, 'wet', 1), (10, 25, 11.9, 'wet', 1), (11, 25, 11.5, 'wet', 1), (12, 25, 11, 'wet', 1),
(13, 25, 11.4, 'wet', 1), (14, 25, 11.2, 'wet', 1), (15, 26, 11.7, 'wet', 1), (16, 26, 10.9, 'wet', 1),
(17, 26, 11.8, 'wet', 1), (18, 27, 11.9, 'wet', 1), (19, 27, 11.8, 'wet', 1), (20, 27, 12.4, 'wet', 1),
(21, 27, 13, 'wet', 1), (22, 27, 13, 'wet', 1);

## DOCK AS
insert into bc.slip (slip.id, slip.length, slip.width, slip.slip_type, slip.dock_id) values
(23, 26, 12.3, 'wet', 2), (24, 26, 10.3, 'wet', 2), (25, 25, 11.5, 'wet', 2), (26, 25, 11.5, 'wet', 2),
(27, 25, 11.63, 'wet', 2), (28, 25, 11, 'wet', 2), (29, 26, 11.5, 'wet', 2), (30, 26, 11.7, 'wet', 2),
(31, 26, 11.5, 'wet', 2), (32, 26, 11.3, 'wet', 2), (33, 26, 11.1, 'wet', 2), (34, 26, 11.5, 'wet', 2),
(35, 26, 11.3, 'wet', 2), (36, 26, 11.5, 'wet', 2), (37, 27, 11.7, 'wet', 2), (38, 27, 11.7, 'wet', 2),
(39, 27, 12.1, 'wet', 2), (40, 27, 10.2, 'wet', 2), (41, 28, 11.1, 'wet', 2), (42, 28, 11.4, 'wet', 2),
(43, 28, 11.3, 'wet', 2), (44, 28, 11.4, 'wet', 2), (45, 28, 10.5, 'wet', 2), (46, 28, 11.4, 'wet', 2),
(47, 29, 11.9, 'wet', 2), (48, 29, 10.5, 'wet', 2), (49, 29, 13.2, 'wet', 2), (50, 29, 9.8, 'wet', 2),
(51, 29, 11.5, 'wet', 2), (52, 27, 10.5, 'wet', 2);


## DOCK BN
insert into bc.slip (slip.id, slip.length, slip.width, slip.slip_type, slip.dock_id) values
(53, null, null, 'wet', 3), (54, 25, 10, 'wet', 3), (55, 25, 10.3, 'wet', 3), (56, 25, 11.4, 'wet', 3),
(57, 26, 11.2, 'wet', 3), (58, 26, 10.7, 'wet', 3), (59, 26, 11.1, 'wet', 3), (60, 25, 11.7, 'wet', 3),
(61, 26, 11.4, 'wet', 3), (62, 25, 11.7, 'wet', 3), (63, 26, 11.4, 'wet', 3), (64, 27, 10.9, 'wet', 3),
(65, 28, 11.8, 'wet', 3), (66, 28, 11, 'wet', 3), (67, 28, 11.2, 'wet', 3), (68, 28, 10.9, 'wet', 3),
(69, 29, 11.7, 'wet', 3), (70, 29, 11.7, 'wet', 3), (71, 29, 11.63, 'wet', 3), (72, 29, 11.9, 'wet', 3),
(73, 30, 11.7, 'wet', 3), (74, 30, 11.7, 'wet', 3), (75, 30, 12.2, 'wet', 3), (76, 30, 12.3, 'wet', 3),
(77, 31, 12.2, 'wet', 3), (78, 31, 12.5, 'wet', 3), (79, 31, 12.5, 'wet', 3), (80, 32, 12.4, 'wet', 3),
(81, 32, 12.3, 'wet', 3), (82, 32, 12.2, 'wet', 3), (83, 32, 12.4, 'wet', 3), (84, 32, 12, 'wet', 3),
(85, 33, 12.7, 'wet', 3), (86, 33, 12.7, 'wet', 3), (87, 33, 13, 'wet', 3), (88, 33, 26, 'wet', 3);

## DOCK BS
insert into bc.slip (slip.id, slip.length, slip.width, slip.slip_type, slip.dock_id) values
(89, 25, 11.2, 'wet', 4), (90, 25, 11, 'wet', 4), (91, 25, 10.7, 'wet', 4), (92, 25, 10.4, 'wet', 4),
(93, 26, 11.1, 'wet', 4), (94, 26, 11, 'wet', 4), (95, 26, 10.7, 'wet', 4), (96, 26, 11.8, 'wet', 4),
(97, 26, 10.8, 'wet', 4), (98, 27, 11.1, 'wet', 4), (99, 27, 11.4, 'wet', 4), (100, 27, 11.1, 'wet', 4),
(101, 28, 10.9, 'wet', 4), (102, 28, 11.5, 'wet', 4), (103, 28, 11.5, 'wet', 4), (104, 28, 11, 'wet', 4),
(105, 29, 11.5, 'wet', 4), (106, 29, 11.8, 'wet', 4), (107, 29, 12, 'wet', 4), (108, 29, 11.5, 'wet', 4),
(109, 30, 11.8, 'wet', 4), (110, 30, 11.8, 'wet', 4), (111, 30, 12.8, 'wet', 4), (112, 31, 12.1, 'wet', 4),
(113, 31, 12.1, 'wet', 4), (114, 31, 12.4, 'wet', 4), (115, 31, 12.2, 'wet', 4), (116, 32, 12.5, 'wet', 4),
(117, 32, 11.7, 'wet', 4), (118, 32, 11.6, 'wet', 4), (119, 32, 11.7, 'wet', 4), (120, 32, 13.5, 'wet', 4),
(121, 33, 12.2, 'wet', 4), (122, 33, 12.9, 'wet', 4), (123, 34, 12.8, 'wet', 4), (124, 34, 13, 'wet', 4);

## DOCK CN
insert into bc.slip (slip.id, slip.length, slip.width, slip.slip_type, slip.dock_id) values
(125,32, 14, 'UNUSABLE', 5), (126, 32, 14, 'wet', 5), (127, 32, 15, 'wet', 5), (128, 32, 15, 'wet', 5), (129, 32, 14, 'wet', 5),
(130, 32, 14, 'wet', 5), (131, 32, 14, 'wet', 5), (132, 32, 15, 'wet', 5), (133, 32, 15, 'wet', 5), (134, 33, 14, 'wet', 5),
(135, 34, 15, 'wet', 5), (136, 34, 15, 'wet', 5), (137, 35, 15, 'wet', 5), (138, 35, 15, 'wet', 5), (139, 35, 14, 'wet', 5),
(140, 34, 14, 'wet', 5), (141, 35, 15, 'wet', 5), (142, 35, 15, 'wet', 5), (143, 35, 10.2, 'wet', 5), (144, 35, 13.7, 'wet', 5),
(145, 35, 14.4, 'wet', 5), (146, 35, 13.5, 'wet', 5), (147, 35, 13.1, 'wet', 5), (148, 35, 13.7, 'wet', 5), (149, 35, 13.8, 'wet', 5),
(150, 35, 13.5, 'wet', 5), (151, 35, 14, 'wet', 5), (152, 35, 13.8, 'wet', 5), (153, 35, 13.5, 'wet', 5), (154, 35, 13.5, 'wet', 5),
(155, 35, 13.5, 'wet', 5), (156, 35, 13.7, 'wet', 5), (157, 35, 13.9, 'wet', 5), (158, 35, 13.9, 'wet', 5);