# GIẢI THÍCH LOGIC CODE - LAB02

## Bài 1: ListView với mảng dữ liệu đơn giản

**Logic hoạt động:**
1. Tạo mảng String `names[]` chứa dữ liệu: `{"Tèo", "Tý", "Bìn", "Bo"}`
2. Sử dụng `ArrayAdapter` để gắn dữ liệu vào ListView
3. Khi click vào item, `onItemClickListener` lấy vị trí và giá trị, hiển thị lên TextView

**Luồng:**
```
Khởi tạo mảng → ArrayAdapter → Gán adapter cho ListView → Click item → Hiển thị thông tin
```

---

## Bài 2: ArrayList và ListView với thêm/xóa

**Logic hoạt động:**
1. Tạo `ArrayList<String>` để lưu danh sách tên (có thể thêm/xóa động)
2. Sử dụng `ArrayAdapter` kết nối ArrayList với ListView
3. Button "Nhập": lấy text từ EditText → thêm vào ArrayList → `notifyDataSetChanged()` để cập nhật UI
4. Click item: hiển thị thông tin
5. Long click item: xóa item khỏi ArrayList → cập nhật UI

**Luồng:**
```
ArrayList → ArrayAdapter → ListView
Nhập text → add() → notifyDataSetChanged() → UI cập nhật
Long click → remove() → notifyDataSetChanged() → UI cập nhật
```

---

## Bài 3: ListView với Object Employee (OOP)

**Logic hoạt động:**
1. Tạo class hierarchy: `Employee` (abstract) → `EmployeeFullTime` và `EmployeePartTime`
2. Mỗi class có phương thức `tinhLuong()` và `toString()` riêng
3. ArrayList chứa các object `Employee` (polymorphism)
4. User nhập thông tin + chọn RadioButton → tạo object tương ứng
5. ArrayAdapter tự động gọi `toString()` để hiển thị

**Luồng:**
```
Nhập id, name → Chọn RadioButton (FullTime/PartTime)
→ new EmployeeFullTime() hoặc new EmployeePartTime()
→ add vào ArrayList<Employee>
→ Adapter gọi toString() → Hiển thị lương tương ứng
```

---

## Bài 4: CustomAdapter cho ListView

**Logic hoạt động:**
1. Tạo `Employee2` class (id, fullName, isManager)
2. Tạo layout `item_employee.xml` cho mỗi dòng (TextView, ImageView)
3. Tạo `EmployeeAdapter extends ArrayAdapter<Employee2>`
4. Override `getView()`: 
   - Inflate layout nếu convertView null (View recycling)
   - Bind dữ liệu: nếu isManager → hiện icon, không thì hiện "Staff"
   - Đổi màu nền theo vị trí chẵn/lẻ
5. User nhập → tạo Employee2 → add vào list → notifyDataSetChanged()

**Luồng:**
```
ArrayList<Employee2> → EmployeeAdapter
getView() gọi cho mỗi item:
  - Kiểm tra isManager → show/hide icon/text
  - Đổi màu nền theo position % 2
  - Return view đã customize
```

---

## Bài 5: GridView và Spinner

**Logic hoạt động:**

### Spinner (dropdown):
1. Tạo `Thumbnail` enum chứa 4 loại (name + drawable resource)
2. Tạo `ThumbnailAdapter` với 2 phương thức:
   - `getView()`: hiển thị item đã chọn (chỉ text)
   - `getDropDownView()`: hiển thị dropdown (hình + text)
3. User chọn thumbnail từ spinner (dialog mode)

### GridView:
1. Tạo `Dish` class (name, thumbnail, isPromotion)
2. Tạo `DishAdapter extends ArrayAdapter<Dish>`
3. Layout `item_dish.xml` có: ImageView (thumbnail), TextView (tên - marquee), ImageView (star)
4. User nhập name + chọn thumbnail + checkbox promotion → add Dish → GridView hiển thị 2 cột
5. TextView tên món: `android:ellipsize="marquee"` + `setSelected(true)` → text chạy nếu dài

**Luồng:**
```
Nhập name → Chọn thumbnail (Spinner) → Checkbox promotion
→ new Dish() → add vào ArrayList
→ DishAdapter render GridView:
  - Set thumbnail image
  - Set text (marquee nếu dài)
  - Show/hide star nếu promotion
```

---

## Bài 6: RecyclerView cơ bản (Hero)

**Logic hoạt động:**
1. Tạo `Hero` class (name, image)
2. Tạo layout `item_hero.xml` (ImageView + TextView overlay)
3. Tạo `HeroAdapter extends RecyclerView.Adapter`:
   - Tạo inner class `ViewHolder extends RecyclerView.ViewHolder` (giữ references đến views)
   - `onCreateViewHolder()`: inflate layout và tạo ViewHolder
   - `onBindViewHolder()`: bind dữ liệu vào ViewHolder tại position
   - `getItemCount()`: trả về số lượng items
4. Trong Activity: 
   - Tạo ArrayList<Hero>
   - Gắn adapter cho RecyclerView
   - Set LayoutManager (LinearLayoutManager)

**Luồng:**
```
ArrayList<Hero> → HeroAdapter → RecyclerView
RecyclerView gọi:
  - onCreateViewHolder() → tạo ViewHolder (cache views)
  - onBindViewHolder() → bind data vào ViewHolder
  - ViewHolder tái sử dụng khi scroll (hiệu năng cao)
```

**So với ListView:**
- RecyclerView bắt buộc dùng ViewHolder pattern → hiệu năng tốt hơn
- Linh hoạt hơn với LayoutManager (Linear, Grid, Staggered)

---

## Bài 7: RecyclerView với CustomAdapter (Employee)

**Logic hoạt động:**
1. Tái sử dụng `Employee2` class và `item_employee.xml` từ Bài 4
2. Tạo `EmployeeRecyclerAdapter extends RecyclerView.Adapter<ViewHolder>`:
   - ViewHolder: cache references (tvFullName, tvPosition, ivManager, llParent)
   - `onCreateViewHolder()`: inflate item_employee.xml
   - `onBindViewHolder()`: 
     - Bind fullName
     - Show icon nếu Manager, show "Staff" nếu không
     - Đổi màu nền chẵn/lẻ
3. User nhập → add Employee2 → `notifyDataSetChanged()`

**Luồng:**
```
ArrayList<Employee2> → EmployeeRecyclerAdapter → RecyclerView
onBindViewHolder() cho từng item:
  - Bind dữ liệu vào ViewHolder
  - Logic show/hide giống Bài 4
  - Đổi màu theo position
→ ViewHolder pattern tự động tái sử dụng
```

**Khác biệt với Bài 4:**
- Bài 4: ListView + ArrayAdapter (getView với convertView manual)
- Bài 7: RecyclerView + Adapter (ViewHolder pattern bắt buộc)
- RecyclerView hiệu năng tốt hơn, ít lag khi scroll danh sách lớn

---

## So sánh tổng quan

| Bài | View | Adapter | Dữ liệu | Đặc điểm |
|-----|------|---------|---------|----------|
| 1 | ListView | ArrayAdapter | String[] | Cơ bản nhất |
| 2 | ListView | ArrayAdapter | ArrayList<String> | Thêm/xóa động |
| 3 | ListView | ArrayAdapter | ArrayList<Employee> | OOP, polymorphism |
| 4 | ListView | Custom ArrayAdapter | ArrayList<Employee2> | Custom layout, getView() |
| 5 | GridView + Spinner | Custom ArrayAdapter | ArrayList<Dish> + Enum | GridView 2 cột, Spinner dropdown |
| 6 | RecyclerView | RecyclerView.Adapter | ArrayList<Hero> | ViewHolder pattern |
| 7 | RecyclerView | RecyclerView.Adapter | ArrayList<Employee2> | Làm lại Bài 4 với RecyclerView |

---

## Key Concepts

### 1. Adapter Pattern
- Cầu nối giữa dữ liệu (ArrayList) và View (ListView/GridView/RecyclerView)
- Adapter quyết định cách hiển thị từng item

### 2. ViewHolder Pattern
- Cache references đến views để tránh `findViewById()` nhiều lần
- Bắt buộc trong RecyclerView, tùy chọn trong ListView

### 3. notifyDataSetChanged()
- Thông báo adapter cập nhật UI khi dữ liệu thay đổi
- Gọi sau khi add/remove item

### 4. RecyclerView vs ListView
- RecyclerView: hiệu năng cao, linh hoạt, bắt buộc ViewHolder
- ListView: đơn giản hơn, ít config hơn, nhưng chậm với dữ liệu lớn

