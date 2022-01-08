var menuList =	[
	{
		id: '2',
		name: '学生管理',
		icon: 'el-icon-user',
		info: '增删改查学生信息',
		childList: [
			{
				id: '2-1',
				name: '查询信息',
				icon: 'el-icon-document-copy',
				url: 'sa-view/student/student-manage.html'
			},
			{
				id: '2-2',
				name: '信息录入',
				icon: 'el-icon-plus',
				url: 'sa-view/student/student-manage-add.html'
			},
			{
				id: '2-3',
				name: '成绩录入',
				icon: 'el-icon-document-remove',
				url: 'sa-view/student/student-test-add.html'
			}
		]
	},
	{
		id: '3',
		name: '课程管理',
		icon: 'el-icon-data-line',
		info: '增删改查课程信息',
		url: 'sa-view/course/course-manage.html'
	},
	{
		id: '4',
		name: '查看课表',
		icon: 'el-icon-search',
		info: '查看课表',
		url: 'sa-view/timetable/timetable.html'
	},
	{
		id: '5',
		name: '教室管理',
		icon: 'el-icon-document-remove',
		info: '增删改查教室信息',
		url: 'sa-view/classroom/classroom-manage.html'
	},
	{
		id: '6',
		name: '教师管理',
		icon: 'el-icon-collection-tag',
		info: '增删改查教师信息',
		url: 'sa-view/teacher/teacher-manage.html'
	},
	{
		id: '7',
		name: '选课',
		icon: 'el-icon-magic-stick',
		info: '学生选课',
		url: 'sa-view/selection/selection.html'
	}
]