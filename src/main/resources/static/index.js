$(document).ready(function () {
    $('#file-input').on('click', function (e) {
        $('#file-input').val(null);
    });

    $('#file-input').on('change', function (e) {
        readSingleFile(e);
    });

    $('#clean').on('click', function (e) {
        cleanFormContent();
    });

    $('#save').on('click', function (e) {

        console.log(createObjectFromForm());
        var post = $.ajax({
            url: "http://localhost:8080/api/save",
            data: JSON.stringify(createObjectFromForm()),
            method: "POST",
            dataType: "json",
            contentType: 'application/json'
        });
        post.fail(function (e) {
            console.log(e.responseText);
        });
    });

    $('#read').on('click', function (e) {
        $.get("http://localhost:8080/api/tracks", function (data) {
            displayFormContent(createObjectToForm(data)['tracks'])
        });
    })
});

function readSingleFile(e) {
    var file = e.target.files[0];
    if (!file) {
        return;
    }
    var reader = new FileReader();
    reader.onload = function (e) {
        var contents = e.target.result;
        displayFormContent(JSON.parse(contents)['tracks']);
    };
    reader.readAsText(file);
}

//todo need to parse it automatically for any arrays
function displayFormContent(data) {
    $('#track_1_id').val(data[0]['id']);
    $('#track_1_name').val(data[0]['name']);
    $('#track_1_description').val(data[0]['description']);
    $('#track_1_length_unit').val(data[0]['length']['unit']);
    $('#track_1_length_value').val(data[0]['length']['value']);

    $('#track_1_car_1_id').val(data[0]['cars'][0]['id']);
    $('#track_1_car_1_code').val(data[0]['cars'][0]['code']);
    $('#track_1_car_1_transmission').val(data[0]['cars'][0]['transmission']);
    $('#track_1_car_1_ai').val(data[0]['cars'][0]['ai']);
    $('#track_1_car_1_max_speed_unit').val(data[0]['cars'][0]['max-speed']['unit']);
    $('#track_1_car_1_max_speed_value').val(data[0]['cars'][0]['max-speed']['value']);

    $('#track_1_car_2_id').val(data[0]['cars'][1]['id']);
    $('#track_1_car_2_code').val(data[0]['cars'][1]['code']);
    $('#track_1_car_2_transmission').val(data[0]['cars'][1]['transmission']);
    $('#track_1_car_2_ai').val(data[0]['cars'][1]['ai']);
    $('#track_1_car_2_max_speed_unit').val(data[0]['cars'][1]['max-speed']['unit']);
    $('#track_1_car_2_max_speed_value').val(data[0]['cars'][1]['max-speed']['value']);
}

function createObjectFromForm() {
    return {
        'tracks': [{
            'id': $('#track_1_id').val(),
            'name': $('#track_1_name').val(),
            'description': $('#track_1_description').val(),
            'length': {
                'unit': $('#track_1_length_unit').val(),
                'value': $('#track_1_length_value').val()
            },
            'cars': [{
                'id': $('#track_1_car_1_id').val(),
                'code': $('#track_1_car_1_code').val(),
                'transmission': $('#track_1_car_1_transmission').val(),
                'ai': $('#track_1_car_1_ai').val(),
                'max-speed': {
                    'unit': $('#track_1_car_1_max_speed_unit').val(),
                    'value': $('#track_1_car_1_max_speed_value').val()
                }
            }, {
                'id': $('#track_1_car_2_id').val(),
                'code': $('#track_1_car_2_code').val(),
                'transmission': $('#track_1_car_2_transmission').val(),
                'ai': $('#track_1_car_2_ai').val(),
                'max-speed': {
                    'unit': $('#track_1_car_2_max_speed_unit').val(),
                    'value': $('#track_1_car_2_max_speed_value').val()
                }
            }]
        }]
    }
}

function createObjectToForm(data) {
    return {
        'tracks': [{
            'id': data[0]['id'],
            'name': data[0]['name'],
            'description': data[0]['description'],
            'length': {
                'unit': data[0]['length']['unit']['name'],
                'value': data[0]['length']['value']
            },
            'cars': [{
                'id': data[0]['cars'][0]['id'],
                'code': data[0]['cars'][0]['code'],
                'transmission': data[0]['cars'][0]['transmission']['name'],
                'ai': data[0]['cars'][0]['ai']['code'],
                'max-speed': {
                    'unit': data[0]['cars'][0]['maxSpeed']['unit']['name'],
                    'value': data[0]['cars'][0]['maxSpeed']['value']
                }
            }, {
                'id': data[0]['cars'][1]['id'],
                'code': data[0]['cars'][1]['code'],
                'transmission': data[0]['cars'][1]['transmission']['name'],
                'ai': data[0]['cars'][1]['ai']['code'],
                'max-speed': {
                    'unit': data[0]['cars'][1]['maxSpeed']['unit']['name'],
                    'value': data[0]['cars'][1]['maxSpeed']['value']
                }
            }]
        }]
    }
}

function cleanFormContent() {
    $('#track_1_id').val("");
    $('#track_1_name').val("");
    $('#track_1_description').val("");
    $('#track_1_length_unit').val("");
    $('#track_1_length_value').val("");

    $('#track_1_car_1_id').val("");
    $('#track_1_car_1_code').val("");
    $('#track_1_car_1_transmission').val("");
    $('#track_1_car_1_ai').val("");
    $('#track_1_car_1_max_speed_unit').val("");
    $('#track_1_car_1_max_speed_value').val("");

    $('#track_1_car_2_id').val("");
    $('#track_1_car_2_code').val("");
    $('#track_1_car_2_transmission').val("");
    $('#track_1_car_2_ai').val("");
    $('#track_1_car_2_max_speed_unit').val("");
    $('#track_1_car_2_max_speed_value').val("");
}