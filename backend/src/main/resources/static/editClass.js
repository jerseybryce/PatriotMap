//list classes
var form = document.querySelector('.editForm')
var dropdown = document.querySelector('.classSelector')
var classID = 0 //value used to track class ids
var className = 1 //value to track class name

//This is just to read data, can be deleted later
fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => console.log(data))

fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => {
  const blank = document.createElement('option')
  blank.value = ''
  blank.innerHTML = ''
  dropdown.appendChild(blank)
    while (className < data.length){
        const option = document.createElement('option')
        option.value = data[classID]
        option.innerHTML = data[className]
        dropdown.appendChild(option)
        classID += 8
        className += 8
    }

    dropdown.addEventListener('change', (event) => {
    var finalID = document.querySelector('.classSelector').value
    console.log
    var finalIndex = 0
    while(data[finalIndex] != finalID && finalIndex < data.length){finalIndex += 8}
    document.getElementById('class_id').value = finalID
    document.getElementById('class_name').value = data[finalIndex + 1]
    //Add one here for weekdays
    document.getElementById('building').value = data[finalIndex + 3]
    document.getElementById('class_time').value = data[finalIndex + 4]
    document.getElementById('class_notes').value = data[finalIndex + 5]
    document.getElementById('class_color').value = data[finalIndex + 6]
    document.getElementById('professor_name').value = data[finalIndex + 7]
    })
  })

