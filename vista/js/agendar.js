let baseUrl = "http://localhost:8080";
document.addEventListener("DOMContentLoaded", () => {
    getHeadquarters(baseUrl + "/headquarter");
    getDateTypes(baseUrl + "/date_type");
    getDoctors(baseUrl + "/doctor");
    getPatients(baseUrl + "/patient");
    let form= document.getElementById("form")
    form.addEventListener("submit", (event) => {
        event.preventDefault();
        data= {
            "dateTypeId": 1,
            "headquarterId": 1,
            "description": "example",
            "initialTime": form.elements['initial_time'].value,
            "finalTime": form.elements['final_time'].value,
            "date": form.elements['date'].value,
            "status": "example",
            "doctorId": "doctor",
            "patientId": "patient"            
        }
        //console.log(data);
        createAppointment(baseUrl + "/scheduling", data);
    });
});

function createAppointment(url, data){
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    }).then(response => console.log(response));
}

function getHeadquarters(url){
    fetch(url)
    .then(response => response.json())
    .then(headquarters => {
        console.log(headquarters);
        headquarters.forEach(headquarter => {
            let option= document.createElement("option");
            option.value= headquarter.id;
            document.getElementById("headquarters").appendChild(option);
        });
    })
}

function getDoctors(url){
    fetch(url)
    .then(response => response.json())
    .then(doctors => {
        console.log(doctors);
        doctors.forEach(doctor => {
            let option= document.createElement("option");
            option.value= doctor.id;
            document.getElementById("doctors").appendChild(option);
        });
    }).catch();
}

function getPatients(url){
    fetch(url)
    .then(response => response.json())
    .then(patients => {
        console.log(patients);
        patients.forEach(patient => {
            let option= document.createElement("option");
            option.value= patient.id;
            document.getElementById("patients").appendChild(option);
        });
    })
}

function getDateTypes(url){
    fetch(url)
    .then(response => response.json())
    .then(data => {
        console.log(data);
    })
}