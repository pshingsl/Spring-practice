const year = document.getElementById("year");
const month = document.getElementById("month");
const day = document.getElementById("day");

for(let y=1950; y<2026; y++){
    const option = document.createElement('option');
    option.value = y;
    option.text = y;
    year.appendChild(option);
}

for(let m=1; m<13; m++){
    const option = document.createElement('option');
    option.value = m;
    option.text = m;
    month.appendChild(option);
}

for(let d=1; d<32; d++){
    const option = document.createElement('option');
    option.value = d;
    option.text = d;
    day.appendChild(option);
}

function connect(){
    const form = document.getElementById("form-test");
    axios
    .post(`/form-test`, { name: form.name.value, gen: form.gen.value,
    year: form.year.value, month: form.month.value, day: form.day.value,
      interest: form.interest.value })
       .then((res) => {
        console.log(name.value + "회원가입 성공")
       })
}