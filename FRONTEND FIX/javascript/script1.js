const quizData = [
    {
        question: "I am planning to go to the party tonight but it is not raining. It’s raining very hard now. I wish ….",
        a: "It had stopped",
        b: "It stops",
        c: "It would stop",
        d: "It will stop",
        correct: "c",
    },
    {
        question: "I wish …. now to watch our play",
        a: "he will be here",
        b: "he is here",
        c: "he were here",
        d: "he has been here",
        correct: "c",
    },


];

const quiz= document.getElementById('quiz')
const answerEls = document.querySelectorAll('.answer')
const questionEl = document.getElementById('question')
const a_text = document.getElementById('a_text')
const b_text = document.getElementById('b_text')
const c_text = document.getElementById('c_text')
const d_text = document.getElementById('d_text')
const submitBtn = document.getElementById('submit')


let currentQuiz = 0
let score = 0

loadQuiz()

function loadQuiz() {

    deselectAnswers()

    const currentQuizData = quizData[currentQuiz]

    questionEl.innerText = currentQuizData.question
    a_text.innerText = currentQuizData.a
    b_text.innerText = currentQuizData.b
    c_text.innerText = currentQuizData.c
    d_text.innerText = currentQuizData.d
}

function deselectAnswers() {
    answerEls.forEach(answerEl => answerEl.checked = false)
}

function getSelected() {
    let answer
    answerEls.forEach(answerEl => {
        if(answerEl.checked) {
            answer = answerEl.id
        }
    })
    return answer
}


submitBtn.addEventListener('click', () => {
    const answer = getSelected()
    if(answer) {
       if(answer === quizData[currentQuiz].correct) {
           score++
       }

       currentQuiz++

       if(currentQuiz < quizData.length) {
           loadQuiz()
       } else {
           quiz.innerHTML = `
           <h3>You answered ${score}/${quizData.length} questions correctly</h3>

           <button onclick="location.reload()">Reload</button>
           `
       }
    }
})