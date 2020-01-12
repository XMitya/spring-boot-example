var app = new Vue({
    el: '#app',
    data: {
        courses: [],
        newCourse: {title: "", duration: "", price: ""}
    },
    methods: {
        loadCourses: function() {
            let self = this;
            $.ajax({
                url: "/courses",
                type: "GET",
                success: function(result) {
                    self.courses = result;
                },
                error: function(error) {
                    console.log(error);
                }
            })
        },
        addCourse: function() {
            let self = this;
            $.ajax({
                url: "/courses/add",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(
                    {
                        "title": self.newCourse.title,
                        "duration": self.newCourse.duration,
                        "price": self.newCourse.price
                    }
                 ),
                success: function(result) {
                    self.loadCourses();

                },
                error: function(error) {
                    console.log(error);
                }
            })
        },
        deleteCourse: function(courseId) {
            let self = this;
            $.ajax({
                url: "/courses/delete/" + self.courses[courseId].id,
                type: "DELETE",
                success: function(result) {
                    self.loadCourses();
                    let res = JSON.parse(result);
                    if (res.error !== "")
                        alert(res.error);
                },
                error: function(error) {
                    console.log(error);
                }
            })
        }
    },
    beforeMount(){
         this.loadCourses()
    }
})