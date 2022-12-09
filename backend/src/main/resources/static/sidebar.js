// Set up leaflet
const map = L.map('map').setView([38.8315, -77.3117], 16);
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);
L.marker([38.8301, -77.3078]).addTo(map);

//Print date
const day = document.querySelector('.day')
const d = new Date()
var date = d.getDay()
var dayName = ''
var dd = String(d.getDate()).padStart(2,'0')
var mm = String(d.getMonth() + 1).padStart(2, '0')


switch(date){
    case 0:
        dayName = '<h2>Sunday</h2>'
        break
    case 1:
        dayName = '<h2>Monday</h2>'
        break
    case 2:
        dayName = '<h2>Tuesday</h2>'
        break
    case 3:
        dayName = '<h2>Wednesday</h2>'
        break
    case 4:
        dayName = '<h2>Thursday</h2>'
        break
    case 5:
        dayName = '<h2>Friday</h2>'
        break
    case 6:
        dayName = '<h2>Saturday</h2>'
        break
    default:
        break
}

const clock = document.createElement('div')
clock.innerHTML = dayName + " " + mm + "/" + dd
day.appendChild(clock)


//Print classes
var sidebar = document.querySelector('.classes')
var num = 1

//This is just to read data, can be deleted later
fetch('http://localhost:8080/methods/getClasses')
    .then((response) => response.json())
    .then((data) => console.log(data))

fetch('http://localhost:8080/methods/getClasses')
    .then((response) => response.json())
    .then((data) => {
        for (const cls of data) {
            const item = document.createElement('li')
            const div = document.createElement('div')
            const str = '<h3>' + cls[0][3] + '</h3>'
            div.style.color = cls[0][6]
            div.innerHTML = str
            item.appendChild(div)
            item.addEventListener('click', () => {
                L.marker([cls[0][0], cls[0][1]]).addTo(map);
            })
            sidebar.appendChild(item)
        }
    })

