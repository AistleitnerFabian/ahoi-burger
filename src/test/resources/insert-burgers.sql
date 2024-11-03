INSERT INTO burger (id, name, description, image, price, weight, vegetarian, available, special_ingredients, allergens)
VALUES
    ('11111111-1111-1111-1111-111111111111', 'Cheeseburger', 'A classic cheeseburger with melted cheese', NULL, 5.99, 200.0, FALSE, TRUE, '{"Cheese", "Lettuce"}', '{"DAIRY"}'),
    ('22222222-2222-2222-2222-222222222222', 'Veggie Burger', 'A delicious vegetarian option', NULL, 7.99, 180.0, TRUE, TRUE, '{"Avocado", "Lettuce"}', '{"SOY"}'),
    ('33333333-3333-3333-3333-333333333333', 'Double Bacon Burger', 'A double-patty burger with crispy bacon', NULL, 9.99, 250.0, FALSE, TRUE, '{"Bacon", "Cheese"}', '{"DAIRY", "GLUTEN"}');
