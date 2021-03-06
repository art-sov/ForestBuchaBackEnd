INSERT INTO PUBLIC.ELECTRIC_METERS (ID, ADD_YARD_LIGHTING, NOTE) VALUES ('77777777-281a-4fe6-85e2-bc9831b2c9fa', true, 'дом 12, квартира 17');
INSERT INTO PUBLIC.ELECTRIC_METERS (ID, ADD_YARD_LIGHTING, NOTE) VALUES ('33333333-63fb-4211-97b6-190e01e795c3', true, 'дом 12, квартира 18');
INSERT INTO PUBLIC.ELECTRIC_METERS (ID, ADD_YARD_LIGHTING, NOTE) VALUES ('55555555-c05a-496f-b95c-49d255339700', false, 'дом 12 квартира 17 кладовка');

--electric meter 12/17
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111111-c05a-496f-b95c-49d255339700', '2018-07-01', 1000, 'дом 12, квартира 17 july', '77777777-281a-4fe6-85e2-bc9831b2c9fa');
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111112-c05a-496f-b95c-49d255339700', '2018-08-01', 1100, 'дом 12, квартира 17 august','77777777-281a-4fe6-85e2-bc9831b2c9fa');
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111113-c05a-496f-b95c-49d255339700', '2018-09-01', 1200, null, '77777777-281a-4fe6-85e2-bc9831b2c9fa');


--electric meter 12/18
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111114-c05a-496f-b95c-49d255339700', '2018-07-01', 1000, 'дом 12, квартира 18 july', '33333333-63fb-4211-97b6-190e01e795c3');
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111115-c05a-496f-b95c-49d255339700', '2018-08-01', 1050, 'дом 12, квартира 18 august','33333333-63fb-4211-97b6-190e01e795c3');
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111116-c05a-496f-b95c-49d255339700', '2018-09-01', 1150, null, '33333333-63fb-4211-97b6-190e01e795c3');


--electric meter 12/17 pantry
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111117-c05a-496f-b95c-49d255339700', '2018-07-01', 0, 'дом 12, квартира 17 кладовка июль', '55555555-c05a-496f-b95c-49d255339700');
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('11111118-c05a-496f-b95c-49d255339700', '2018-08-01', 20, 'дом 12, квартира 17 кладовка август','55555555-c05a-496f-b95c-49d255339700');
INSERT INTO PUBLIC.ELECTRIC_METERS_VALUES (ID, VALUE_DATE, METER_COUNT, NOTE, ELECTRIC_METER_ID) VALUES ('111111119-c05a-496f-b95c-49d255339700', '2018-09-01', 38, null, '55555555-c05a-496f-b95c-49d255339700');


-- user from 12/17, electric meter 12/17, july - september
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES ('11111120-c05a-496f-b95c-49d255339700', '11111111-c05a-496f-b95c-49d255339700', 100, 'за июль', '77777777-281a-4fe6-85e2-bc9831b2c9fa');
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '11111111-c05a-496f-b95c-49d255339700', 100, 'за август', '77777777-281a-4fe6-85e2-bc9831b2c9fa');
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '11111111-c05a-496f-b95c-49d255339700', 0, 'за сентябрь', '77777777-281a-4fe6-85e2-bc9831b2c9fa');


-- user from 12/18, electric meter 12/18, july - september
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '22222222-c05a-496f-b95c-49d255339700', 50, 'за июль', '33333333-63fb-4211-97b6-190e01e795c3');
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '22222222-c05a-496f-b95c-49d255339700', 100, 'за август', '33333333-63fb-4211-97b6-190e01e795c3');
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '22222222-c05a-496f-b95c-49d255339700', 0, 'за сентябрь', '33333333-63fb-4211-97b6-190e01e795c3');


-- user from 12/17, electric meter 12/17 pantry, july - september
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '11111111-c05a-496f-b95c-49d255339700', 20, 'за июль', '55555555-c05a-496f-b95c-49d255339700');
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '11111111-c05a-496f-b95c-49d255339700', 18, 'за август', '55555555-c05a-496f-b95c-49d255339700');
INSERT INTO PUBLIC.ELECTRIC_METERS_ACCRUALS (ID, USER_ID, VALUE_ACCRUAL, NOTE, ELECTRIC_METER_ID) VALUES (uuid(), '11111111-c05a-496f-b95c-49d255339700', 0, 'за сентябрь', '55555555-c05a-496f-b95c-49d255339700');