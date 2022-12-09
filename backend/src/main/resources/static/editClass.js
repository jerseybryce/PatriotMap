//list classes
var form = document.querySelector('.editForm')
var dropdown = document.querySelector('.classSelector')
const building = document.querySelector('.building');
var buildingName = 0
var buildingAKA = 1
var buildingID = 2

//Get building names
fetch('http://localhost:8080/methods/getBuildingNames')
  .then((response) => response.json())
  .then((data) => {
    while(buildingAKA < data.length){
        if(data[buildingAKA] != null){
            const option = document.createElement('option')
            var str = data[buildingAKA] + ' - ' + data[buildingName]
            option.value = data[buildingID]
            option.innerHTML = str
            building.appendChild(option)
        }
        buildingName += 3
        buildingAKA += 3
        buildingID += 3
    }
  })

fetch('http://localhost:8080/methods/getClasses')
  .then((response) => response.json())
  .then((data) => {
  const blank = document.createElement('option')
  blank.value = ''
  blank.innerHTML = ''
  dropdown.appendChild(blank)
    for (const cls of data) {
        const option = document.createElement('option')
        option.value = cls[0][2]
        option.innerHTML = cls[0][3]
        dropdown.appendChild(option)
    }

    dropdown.addEventListener('change', (event) => {
    var finalCLS = null

    for (const cls of data){
        if (cls[0][2] == document.querySelector('.classSelector').value){
            finalCLS = cls[0]
        }
    }

        document.getElementById('class_id').value = finalCLS[2]
        document.getElementById('class_name').value = finalCLS[3]
        document.getElementById('building').value = finalCLS[9]
        document.getElementById('class_time').value = finalCLS[7]
        document.getElementById('class_notes').value = finalCLS[4]
        document.getElementById('class_color').value = finalCLS[6]
        document.getElementById('professor_name').value = finalCLS[5]
    })
  })

