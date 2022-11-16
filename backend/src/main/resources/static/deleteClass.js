//list classes
var dropdown = document.querySelector('.deleteDropdown')
var classID = 0 //value used to track class ids
var className = 1 //value to track class name

//This is just to read data, can be deleted later
fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => console.log(data))

fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => {
    while (className < data.length){
        const option = document.createElement('option')
        option.value = data[classID]
        option.innerHTML = data[className]
        dropdown.appendChild(option)
        classID += 8
        className += 8
    }
  })

 function delClass(){
         fetch('http://localhost:8080/methods/deleteClass', {method: 'DELETE'})
 }