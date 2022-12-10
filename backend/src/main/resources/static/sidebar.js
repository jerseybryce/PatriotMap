// Set up leaflet
const map = L.map('map').setView([38.8315, -77.3117], 16);
L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);
L.marker([38.8301, -77.3078]).addTo(map);

//Print date
const dateLabel = document.querySelector('.day')
const d = new Date()
var date = d.getDay()
var dayName = ''
var dd = String(d.getDate()).padStart(2,'0')
var mm = String(d.getMonth() + 1).padStart(2, '0')


switch(date){
    case 0:
        dayName = 'Sunday'
        break
    case 1:
        dayName = 'Monday'
        break
    case 2:
        dayName = 'Tuesday'
        break
    case 3:
        dayName = 'Wednesday'
        break
    case 4:
        dayName = 'Thursday'
        break
    case 5:
        dayName = 'Friday'
        break
    case 6:
        dayName = 'Saturday'
        break
    default:
        break
}

const clock = document.createElement('div')
clock.innerHTML = "<h2>" + dayName + "</h2> " + mm + "/" + dd
dateLabel.appendChild(clock)


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
            const div = document.createElement('div')
            div.classList.add('border-bottom')
            div.classList.add('border-dark')
            div.classList.add('border-1')

            var days = ''

            if (cls[0][8] != null){
                days += ' - '
                var d_arr = cls[0][8].split(',')
                console.log(d_arr.length)
                for(let i = 0; i < d_arr.length; i++){
                    if (d_arr[i] == 'Thursday'){
                        days += 'R/'
                    }
                    else{
                        days += d_arr[i].charAt(0) + '/'
                    }
                }

                days = days.slice(0,-1)
            }

            var am_pm = 'AM'
            var class_time = cls[0][7].slice(0,2);
            var tmp = parseInt(class_time)

            if(tmp > 12){
                tmp = tmp % 12
                am_pm = 'PM'
            }

            var location = ''
            if(cls[0][10] != null){
                location += ' @ ' + cls[0][10]
            }

            class_time = tmp.toString() + cls[0][7].slice(2, cls[0][7].length) + ' ' + am_pm
            const str = cls[0][3] + days

            div.style.color = cls[0][6]
            div.innerHTML = str + '<br>' + class_time + location
            div.style.fontSize = "20px"

            if(cls[0][8] != null && cls[0][8].includes(dayName)){
                L.marker([cls[0][0], cls[0][1]]).addTo(map);
            }
            div.addEventListener('click', () => {
                L.marker([cls[0][0], cls[0][1]]).addTo(map);
            })
            sidebar.appendChild(div)
        }
    })

