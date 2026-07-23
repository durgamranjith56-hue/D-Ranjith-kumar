var checkIfInstanceOf = function(obj, classFunction) {
    if (obj === null || obj === undefined || typeof classFunction !== "function") {
        return false;
    }

    // Convert primitive values to their wrapper objects
    let current = Object(obj);

    // Traverse the prototype chain
    while (current !== null) {
        if (current.constructor === classFunction) {
            return true;
        }

        current = Object.getPrototypeOf(current);
    }

    return false;
};
